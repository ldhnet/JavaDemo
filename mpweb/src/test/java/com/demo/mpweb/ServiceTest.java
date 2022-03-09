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
    void  testProperties()
    {
        System.out.println(bookCase);
    }
}
