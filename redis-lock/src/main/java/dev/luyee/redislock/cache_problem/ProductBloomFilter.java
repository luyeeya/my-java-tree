package dev.luyee.redislock.cache_problem;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * 布隆过滤器
 */
public class ProductBloomFilter {
    private final RedissonClient redissonClient;

    private RBloomFilter<String> bloomFilter;

    private final String BLOOM_FILTER_NAME = "bloom_filter:product"; // 会作为key存储到Redis

    public ProductBloomFilter() {
        // 初始化Redisson客户端
        Config config = new Config();
        config.useSingleServer().setPassword("<pwd>").setAddress("redis://111.231.11.199:8007");
        this.redissonClient = Redisson.create(config);
        // 初始化布隆过滤器
        init();
    }

    public void test() {
        // set key
        cacheProduct("apple");
        cacheProduct("banana");
        // get to know if key exists
        System.out.println("apple exists: " + productExists("apple"));
        System.out.println("banana exists: " + productExists("banana"));
        System.out.println("orange exists: " + productExists("orange"));
    }

    public void test2() {
        // set key
        cacheProduct("apple");
        // get to know if key exists
        System.out.println("apple exists: " + productExists("apple"));
        System.out.println("banana exists: " + productExists("banana"));
        System.out.println("orange exists: " + productExists("orange"));
    }

    /**
     * 初始化布隆过滤器（由于布隆过滤器无法删除或修改数据，因此需要定期调用该方法）
     */
    public void init() {
        if (this.bloomFilter != null && this.bloomFilter.isExists()) {
            this.bloomFilter.delete(); // 删除原布隆过滤器
        }
        this.bloomFilter = this.redissonClient.getBloomFilter(BLOOM_FILTER_NAME);
        this.bloomFilter.tryInit(
                100L, // expectedInsertions：预计元素个数
                0.03 // falseProbability：误判率
        );
    }

    /**
     * 每次缓存时，也将key添加到布隆过滤器
     */
    public void cacheProduct(String productKey) {
        this.bloomFilter.add(productKey);
    }

    /**
     * 使用布隆过滤器判断key是否存在
     */
    public boolean productExists(String productKey) {
        return this.bloomFilter.contains(productKey);
    }

    public static void main(String[] args) {
        ProductBloomFilter bloomFilter = new ProductBloomFilter();
        bloomFilter.test();
        bloomFilter.init();
        bloomFilter.test2();
    }
}
