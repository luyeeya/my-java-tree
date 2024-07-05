package dev.luyee.redislock.cache_problem;

import com.alibaba.fastjson.JSON;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 缓存问题：缓存雪崩、缓存击穿、缓存穿透
 */
@Service
public class CacheProblem {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private ProductDao productDao;

    private static final String PRODUCT_CACHE_PREFIX = "product:";

    private static final String EMPTY_CACHE = "{}";

    private static final String LOCK_PRODUCT_CACHE_REBUILD_PREFIX = "lock:cache_rebuild:product:";

    private static final String LOCK_PRODUCT_UPDATE_PREFIX = "lock:update:product:";

    /**
     * 创建商品
     */
    public Product createProduct(Product product) {
        Product productResult = null;
        // 加锁（解决双写不一致问题）
        RReadWriteLock productUpdateLock = redissonClient.getReadWriteLock(LOCK_PRODUCT_UPDATE_PREFIX + product.getId()); // 使用读写锁优化
        RLock writeLock = productUpdateLock.writeLock(); // 更新数据库操作，使用写锁
        writeLock.lock();
        try {
            productResult = productDao.create(product);
            stringRedisTemplate.opsForValue().set(PRODUCT_CACHE_PREFIX + product.getId(), JSON.toJSONString(productResult),
                    genProductCacheTimeout(), TimeUnit.SECONDS);
        } catch (Exception e) {
            // handle exception...
        } finally {
            writeLock.unlock();
        }
        return productResult;
    }

    /**
     * 更新商品
     */
    public Product updateProduct(Product product) {
        Product productResult = null;
        // 加锁（解决双写不一致问题）
        RReadWriteLock productUpdateLock = redissonClient.getReadWriteLock(LOCK_PRODUCT_UPDATE_PREFIX + product.getId()); // 使用读写锁优化
        RLock writeLock = productUpdateLock.writeLock(); // 更新数据库操作，使用写锁
        writeLock.lock();
        try {
            productResult = productDao.update(product);
            stringRedisTemplate.delete(PRODUCT_CACHE_PREFIX + product.getId());
        } catch (Exception e) {
            // handle exception...
        } finally {
            writeLock.unlock();
        }
        return productResult;
    }

    /**
     * 以查询商品为例，展示如何解决缓存雪崩、缓存击穿和缓存穿透问题
     */
    public Object queryProduct(String id) {
        // 首次查询缓存
        Product product = getProductFromCache(id);
        if (product != null) {
            return product;
        }
        // 加锁（用于并发重建热点缓存时，解决缓存击穿问题）
        RLock productCacheRebuildLock = redissonClient.getLock(LOCK_PRODUCT_CACHE_REBUILD_PREFIX + id);
        try {
            productCacheRebuildLock.lock();
            // 串行转并发：预估第一个抢到锁的线程要执行的时间，在这个预估时间之后，将所有线程放开，理想情况下缓存已经重建，因此这些放开的线程可获取到缓存后直接返回（高并发下可权衡使用）
            // productCacheRebuildLock.tryLock(1, TimeUnit.SECONDS); // tryLock()指定时间后，即使没获取到锁（返回false），线程也会往下执行
            // 再次查询缓存
            product = getProductFromCache(id);
            if (product != null) {
                return product;
            }
            // 查数据库（只有第一个抢到锁的线程会查询数据库，解决了缓存击穿问题）
            product = getProductFromDB(id);
        } catch (Exception e) {
            // handle exception...
        } finally {
            productCacheRebuildLock.unlock();
        }
        return product;
    }

    private Product getProductFromCache(String id) {
        String cacheKey = PRODUCT_CACHE_PREFIX + id;
        String productStr = stringRedisTemplate.opsForValue().get(cacheKey);
        if (productStr != null) {
            if (EMPTY_CACHE.equals(productStr)) {
                stringRedisTemplate.expire(cacheKey, genEmptyCacheTimeout(), TimeUnit.SECONDS);
            }
            // 读延期：刷新缓存过期时间（使得热点数据缓存不失效）
            stringRedisTemplate.expire(cacheKey, genProductCacheTimeout(), TimeUnit.SECONDS);
            return JSON.parseObject(productStr, Product.class);
        }
        return null;
    }

    private Product getProductFromDB(String id) {
        Product product = null;
        String cacheKey = PRODUCT_CACHE_PREFIX + id;
        // 加锁（用于更新缓存时，解决双写不一致问题）
        RReadWriteLock productUpdateLock = redissonClient.getReadWriteLock(LOCK_PRODUCT_UPDATE_PREFIX + id); // 使用读写锁优化
        RLock readLock = productUpdateLock.readLock(); // 查询数据库操作，使用读锁（允许多个线程并发执行：查询数据库+更新缓存）
        readLock.lock();
        try {
            product = productDao.query(id);
            if (product != null) {
                // 更新缓存（使用随机缓存过期时间，解决了缓存雪崩问题）
                stringRedisTemplate.opsForValue().set(cacheKey, JSON.toJSONString(product), genProductCacheTimeout(), TimeUnit.SECONDS);
            } else {
                // 缓存空值（解决缓存穿透问题）
                stringRedisTemplate.opsForValue().set(cacheKey, EMPTY_CACHE, genEmptyCacheTimeout(), TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            // handle exception...
        } finally {
            readLock.unlock();
        }
        return product;
    }

    private long genProductCacheTimeout() {
        return 24 * 60 * 60 + new Random().nextInt(5) * 60 * 60;
    }

    private long genEmptyCacheTimeout() {
        return 30 * 60 + new Random().nextInt(30) * 60 * 60;
    }
}
