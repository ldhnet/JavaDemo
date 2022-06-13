package org.ldh.mybatisdemo;

import org.junit.jupiter.api.Test;
import org.ldh.mybatisdemo.domain.SysUser;
import org.ldh.mybatisdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {
	@Autowired
	private IUserService userInterface;

	@Test
	void contextLoads() {
		System.out.println("test...123...");
	}
	@Test
	void  testBody() {
		List<SysUser> sysUsers = userInterface.selectUserList();
		System.out.println(sysUsers);
	}
}
