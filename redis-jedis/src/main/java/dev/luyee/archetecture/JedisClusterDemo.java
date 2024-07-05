package dev.luyee.archetecture;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Jedis 访问 Redis 集群
 */
public class JedisClusterDemo {
    public static void main(String[] args) {
        GenericObjectPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // jedis 连接池配置
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(5);

        // 集群所有节点
        Set<HostAndPort> clusterNodes = new HashSet<>();
        clusterNodes.add(new HostAndPort("120.55.167.193", 8001));
        clusterNodes.add(new HostAndPort("120.55.167.193", 8002));
        clusterNodes.add(new HostAndPort("120.55.167.193", 8003));
        clusterNodes.add(new HostAndPort("150.158.119.205", 8004));
        clusterNodes.add(new HostAndPort("150.158.119.205", 8005));
        clusterNodes.add(new HostAndPort("150.158.119.205", 8006));
        clusterNodes.add(new HostAndPort("117.72.37.81", 8007));
        clusterNodes.add(new HostAndPort("117.72.37.81", 8008));
        clusterNodes.add(new HostAndPort("117.72.37.81", 8009));

        // 连接集群
        // connectionTimeout: 6000 表示客户端连接超时时间
        // soTimeout: 5000 表示客户端读写超时时间
        // xxx: 表示Redis密码
        try (JedisCluster jedisCluster = new JedisCluster(clusterNodes, 6000, 5000, 10, "xxx", jedisPoolConfig)) {
            // 读写操作
            System.out.println(jedisCluster.set("cluster", "520"));
            System.out.println(jedisCluster.get("cluster"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
