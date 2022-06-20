package org.ldh.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		System.out.println("http://localhost:7001/pages/books.html");
		System.out.println("http://localhost:7001/swagger-ui.html");

		System.out.println("启动成功！");
	}

}
