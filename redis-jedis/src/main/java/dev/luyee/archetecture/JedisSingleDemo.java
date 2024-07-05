package dev.luyee.archetecture;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

/**
 * 直接访问 Redis
 */
public class JedisSingleDemo {
    public static void main(String[] args) {
        // jedis 连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(5);

        // jedis 连接池（timeout=3000 既是连接超时也是读写超时）
        try (JedisPool jedisPool = new JedisPool(jedisPoolConfig, "111.231.11.199", 6379, 3000, null)) {
            Jedis jedis = jedisPool.getResource();
            System.out.println(jedis.set("idea", "520"));
            System.out.println(jedis.get("idea"));

            // 管道
            Pipeline pipeline = jedis.pipelined();
            for (int i = 1; i <= 10; i++) {
                pipeline.set("xjj" + i, String.valueOf(i));
            }
            System.out.println(pipeline.syncAndReturnAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
