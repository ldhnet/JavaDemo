package com.demo.mpweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务操作
@EnableCaching//开启缓存
public class MpwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpwebApplication.class, args);
		System.out.println("启动成功");
	}

}
