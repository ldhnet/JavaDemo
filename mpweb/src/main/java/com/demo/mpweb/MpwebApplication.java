package com.demo.mpweb;

import com.demo.mpweb.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务操作
@EnableCaching//开启缓存
@EnableAsync
public class MpwebApplication {
	public static void main(String[] args) {
		//System.setProperty("logging.level.root","info");
		ConfigurableApplicationContext ctx = SpringApplication.run(MpwebApplication.class, args);
		//获取bean
		ServerConfig bean =	ctx.getBean(ServerConfig.class);
		System.out.println(bean.toString());
		System.out.println("启动成功");
	}

}
