package com.demo.mpweb.lockUt;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class RedisLockTest {
    //总库存
    private long nKuCuen = 0;
    //商品key名字
    private String shangpingKey = "computer_key";
    //获取锁的超时时间 秒
    private int timeout = 30 * 1000;

    @Test
    void qiangdan() {
        //抢到商品的用户
        List<String> shopUsers = new ArrayList<>();

        //构造很多用户
        List<String> users = new ArrayList<>();

        IntStream.range(1, 100).forEach(b -> {
            users.add("神羊-" + b);
        });

        //初始化库存
        nKuCuen = 5;

        //模拟开抢 parallelStream().
        users.parallelStream().forEach(b -> {
            String shopUser = qiang(b);
            if (!StringUtils.isEmpty(shopUser)) {
                shopUsers.add(shopUser);
            }
        });
        shopUsers.stream().forEach(c -> {
            System.out.println(c);
        });
        //System.out.println(shopUsers);
    }

    /**
     * 模拟抢单动作
     *
     * @param b
     * @return
     */
    private synchronized String qiang(String b) {
        //用户开抢时间
        long startTime = System.currentTimeMillis();

        //未抢到的情况下，30秒内继续获取锁
        while ((startTime + timeout) >= System.currentTimeMillis()) {
            //商品是否剩余
            if (nKuCuen <= 0) {
                break;
            }
            if (true) {//jedisUitil.setnx(shangpingKey, b)
                //用户b拿到锁
                log.info("用户{}拿到锁...", b);
                try {
                    //商品是否剩余
                    if (nKuCuen <= 0) {
                        break;
                    }

                    //模拟生成订单耗时操作，方便查看：神牛-50 多次获取锁记录
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //抢购成功，商品递减，记录用户
                    nKuCuen -= 1;

                    //抢单成功跳出
                    log.info("用户{}抢单成功跳出...所剩库存：{}", b, nKuCuen);

                    return b + "抢单成功，所剩库存：" + nKuCuen;
                } finally {
                    log.info("用户{}释放锁...", b);
                    //释放锁
                    //jedisUitil.delnx(shangpingKey, b);
                }
            } else {
                //用户b没拿到锁，在超时范围内继续请求锁，不需要处理
                //if (b.equals("神牛-50") || b.equals("神牛-69")) {
                //logger.info("用户{}等待获取锁...", b);
                //}
            }
        }
        return "";//等待超时
    }
}
