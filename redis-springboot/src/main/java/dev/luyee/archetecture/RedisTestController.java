/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.luyee.archetecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test_sentinel")
    public void testSentinel() {
        for (int i = 1; i <= 100; i++) {
            try {
                stringRedisTemplate.opsForValue().set("test_sentinel_" + i, String.valueOf(i));
                System.out.println("设置key：test_sentinel_" + i);
                Thread.sleep(6000);
            } catch (Exception e) {
                System.out.println("设置key出错：test_sentinel_" + i);
            }
        }
    }

    @RequestMapping("/test_cluster")
    public void testCluster() {
        for (int i = 1; i <= 3; i++) {
            try {
                // 会使用 key 的 {test_cluster} 前缀来 hash，使得这批 key 可以存入同一个 Slot
                stringRedisTemplate.opsForValue().set("{test_cluster}:" + i, String.valueOf(i));
                System.out.println("设置key：{test_cluster}:" + i);
                Thread.sleep(6000);
            } catch (Exception e) {
                System.out.println("设置key出错：{test_cluster}:" + i);
            }
        }
    }
}
