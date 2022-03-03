package com.demo.mpweb;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.mpweb.dao.bookDao;
import com.demo.mpweb.domain.Book;
import com.demo.mpweb.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MpwebApplicationTests {

	@Autowired
	private bookDao _bookDao;

	@Autowired
	private IBookService bookService;

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
