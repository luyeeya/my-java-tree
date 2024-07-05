package dev.luyee.archetecture;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过哨兵集群访问 Redis
 */
public class JedisSentinelDemo {
    public static void main(String[] args) {
        // jedis 连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(5);

        // 主节点名称
        String masterName = "mymaster";
        // 哨兵实例集合
        Set<String> sentinels = new HashSet<>();
        sentinels.add(new HostAndPort("111.231.11.199", 26379).toString());
        sentinels.add(new HostAndPort("111.231.11.199", 26380).toString());
        sentinels.add(new HostAndPort("111.231.11.199", 26381).toString());

        // JedisSentinelPool 本质上还是 JedisPool
        try (JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName, sentinels, jedisPoolConfig, 3000, null)) {
            Jedis jedis = jedisSentinelPool.getResource();
            System.out.println(jedis.set("sentinel", "666"));
            System.out.println(jedis.get("sentinel"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
