package dev.luyee.redislock;

import org.redisson.Redisson;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RedisLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisLockApplication.class, args);
    }

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useClusterServers()
                .setTimeout(10000)
                .setConnectTimeout(10000)
                .setPassword("<pwd>")
                .setNodeAddresses(Arrays.asList(
                        "redis://120.55.167.193:8001", "redis://120.55.167.193:8002", "redis://120.55.167.193:8003",
                        "redis://150.158.119.205:8004", "redis://150.158.119.205:8005", "redis://150.158.119.205:8006",
                        "redis://111.231.11.199:8007", "redis://111.231.11.199:8008", "redis://111.231.11.199:8009")
                );
        config.setCodec(new JsonJacksonCodec());
        return (Redisson) Redisson.create(config);
    }
}
