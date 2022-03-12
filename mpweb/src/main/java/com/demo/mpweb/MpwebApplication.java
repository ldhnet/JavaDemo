package com.demo.mpweb;

import com.demo.mpweb.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务操作
@EnableCaching//开启缓存
=======
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
>>>>>>> 6b37c5aad120acde5f37da58b02f4b230d62bfd6
public class MpwebApplication {
	public static void main(String[] args) {
		//System.setProperty("logging.level.root","info");
		ConfigurableApplicationContext ctx = SpringApplication.run(MpwebApplication.class, args);
		ServerConfig bean =	ctx.getBean(ServerConfig.class);
		System.out.println(bean.toString());
		System.out.println("启动成功");
	}

}
