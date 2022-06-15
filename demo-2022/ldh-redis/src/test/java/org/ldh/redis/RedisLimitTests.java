package org.ldh.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisLimitTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        for(int i = 1; i <= 100; i++){
            String result =  limitFlow(i);
            System.out.println(result);
//            try {
//
//                //TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
    public String limitFlow(Integer i){
        Long currentTime = new Date().getTime();
        long intervalTime = 10;
        System.out.println(currentTime);
        if(redisTemplate.hasKey("limit")) {
            Integer count = redisTemplate.opsForZSet().rangeByScore("limit", currentTime -  intervalTime, currentTime).size();        // intervalTime是限流的时间
            System.out.println(count);
            if (count != null && count > 5) {
                return "每分钟最多只能访问5次";
            }
        }
        redisTemplate.opsForZSet().add("limit", UUID.randomUUID().toString(),currentTime);
        redisTemplate.expire("limit",10,TimeUnit.SECONDS);

        return "第"+ i +"访问成功";
    }
}
