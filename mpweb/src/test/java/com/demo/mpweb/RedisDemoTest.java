package com.demo.mpweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisDemoTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void set() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age", 55);
        System.out.println("test redis test");
    }

    @Test
    void get() {
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("age");

        System.out.println(age);
    }

    @Test
    void hset() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("info", "a", "aaa");
    }
    @Test
    void hget() {
        HashOperations ops = redisTemplate.opsForHash();
        Object val = ops.get("info", "a");
        System.out.println(val);

    }
}
