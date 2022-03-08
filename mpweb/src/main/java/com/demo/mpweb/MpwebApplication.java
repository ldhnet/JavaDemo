package com.demo.mpweb;

import com.demo.mpweb.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MpwebApplication {
	public static void main(String[] args) {
		//System.setProperty("logging.level.root","info");
		ConfigurableApplicationContext ctx = SpringApplication.run(MpwebApplication.class, args);
		ServerConfig bean =	ctx.getBean(ServerConfig.class);
		System.out.println(bean.toString());
		System.out.println("启动成功");
	}

}
