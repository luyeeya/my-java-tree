package dev.luyee.redislock.distributed_locks;

import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis 分布式锁
 */
@RestController
public class RedisLockController {
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 扣减库存
     */
    @RequestMapping("/deduct_stock/{id}")
    public String deductStock(@PathVariable("id") String productId) {
        String lockKey = "lock:product:" + productId;
        RLock lock = redissonClient.getLock(lockKey); // 获取锁对象
        lock.lock();
        try {
            String stockKey = "stock:" + productId;
            RBucket<Object> stockBucket = redissonClient.getBucket(stockKey);
            int stock = Integer.parseInt(String.valueOf(stockBucket.get()));
            if (stock <= 0) {
                System.out.println("扣减失败，库存不足");
                return "fail";
            }
            int currentStock = stock - 1;
            stockBucket.set(currentStock);
            System.out.println("扣减成功，剩余库存：" + currentStock);
        } finally {
            lock.unlock();
        }
        return "success";
    }
}
