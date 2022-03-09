package com.demo.mpweb;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.mpweb.dao.bookDao;
import com.demo.mpweb.domain.Book;
import com.demo.mpweb.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.util.List;


//@SpringBootTest(properties = {"test.prop=testValue1"})
//@SpringBootTest(args = {"test.prop=testValue2"})
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc//开启虚拟MVC调用
//@SpringBootTest
class MpwebApplicationTests {

	@Autowired
	private bookDao _bookDao;

	@Autowired
	private IBookService bookService;


	@Value("${server.port}")
	private String serverport;
	@Test
	void  testProperties()
	{
		System.out.println(serverport);
	}
	@Test
	void contextLoads() {
		QueryWrapper<Book> qw=new QueryWrapper<>();
		qw.like("Name","5");
		List<Book> list=_bookDao.selectList(qw);
		System.out.println(list);

		String name=null;
		LambdaQueryWrapper<Book> lbqw=new LambdaQueryWrapper<>();

		//if (name != null) lbqw.like(Book::getName,name);

		lbqw.like(name != null,Book::getName,name);
		List<Book> list2=_bookDao.selectList(lbqw);
		System.out.println(list2);

	}
	@Test
	void  getlist()
	{
		List<Book> list2=bookService.list();
		System.out.println(list2);
		List<Book> list=bookService.getAll();
		System.out.println(list);
		Book book = bookService.getById(1);
		System.out.println(book.toString());
	}

}
