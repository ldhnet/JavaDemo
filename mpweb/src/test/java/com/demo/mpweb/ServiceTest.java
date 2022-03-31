package com.demo.mpweb;

import com.demo.mpweb.dao.bookDao;
import com.demo.mpweb.domain.Book;
import com.demo.mpweb.domain.BookCase;
import com.demo.mpweb.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class ServiceTest {
    @Autowired
    private bookDao _bookDao;

    @Autowired
    private IBookService bookService;
    @Autowired
    private BookCase bookCase;
    @Test
    void  testSave()
    {
        Book book=new Book();
        book.setName("springboot");
        book.setType("springboot7");
        book.setDescription("springboot7");
        bookService.save(book);
    }
    @Test
    void  testUpdate()
    {
        Book book=new Book();
        book.setId(1);
        book.setName("springboot1111");
        book.setType("springboot1111");
        book.setDescription("springboot1111");
        bookService.updateById(book);
    }
    @Test
    void  testGetAll()
    {
        List<Book> all = bookService.getAll();
        List<Book> list = all.stream().filter(user -> user.getName().indexOf("6") > -1 || user.getDescription().indexOf("3") > -1)
                .collect(Collectors.toList());

        list.stream().forEach(c->{
            System.out.println(c.getId() + "===" +c.getName() + "===" + c.getDescription());
        });
    }
    @Test
    void  testGetAllB()
    {
        List<Book> all = bookService.getAll();
        List<Book> list = all.stream()
                .filter(user -> user.getName().indexOf("6") > -1 || user.getDescription().indexOf("3") > -1)
                .collect(Collectors.toList());

        list.stream().forEach(c->{
            System.out.println(c.getId() + "===" +c.getName() + "===" + c.getDescription());
        });
    }

    @Test
    void  testProperties()
    {
        System.out.println("printin test");
        System.out.println(bookCase);
    }
}
