package org.ldh.jdbcweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		System.out.println("http://localhost:7002");
		System.out.println("启动成功！");
	}

}
