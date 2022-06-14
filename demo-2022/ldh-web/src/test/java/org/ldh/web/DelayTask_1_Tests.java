package org.ldh.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
class DelayTask_1_Tests {
	// 存放定时任务
	private static Map<String, Long> _TaskMap = new HashMap<>();
	@Test
	void contextLoads() {
		System.out.println("test...1...");
	}
	@Test
	void mainTask() {
		System.out.println("程序启动时间：" + LocalDateTime.now());
		// 添加定时任务
		_TaskMap.put("task-1", Instant.now().plusSeconds(3).toEpochMilli()); // 延迟 3s

		// 调用无限循环实现延迟任务
		loopTask();
	}
	/**
	 * 无限循环实现延迟任务
	 */
	private static void loopTask() {
		Long itemLong = 0L;
		while (true) {
			Iterator it = _TaskMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				itemLong = (Long) entry.getValue();
				// 有任务需要执行
				if (Instant.now().toEpochMilli() >= itemLong) {
					// 延迟任务，业务逻辑执行
					System.out.println("执行任务：" + entry.getKey() + " ，执行时间：" + LocalDateTime.now());
					// 删除任务
					_TaskMap.remove(entry.getKey());
				}
			}
		}
	}
}
