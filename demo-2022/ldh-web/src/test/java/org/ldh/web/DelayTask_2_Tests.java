package org.ldh.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DelayTask_2_Tests {
	@Test
	void contextLoads() {
		System.out.println("test...2...");
	}
	@Test
	void mainTask() {
		System.out.println("程序启动时间：" + LocalDateTime.now());
		scheduledExecutorServiceTask();
	}
	/**
	 * ScheduledExecutorService 实现固定频率一直循环执行任务
	 */
	private static void scheduledExecutorServiceTask() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleWithFixedDelay(
				new Runnable() {
					@Override
					public void run() {
						// 执行任务的业务代码
						System.out.println("执行任务" +
								" ，执行时间：" + LocalDateTime.now());
					}
				},
				2, // 初次执行间隔
				2, // 2s 执行一次
				TimeUnit.SECONDS);
	}
}
