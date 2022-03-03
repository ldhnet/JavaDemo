package com.demo.mpweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.mpweb.dao.bookDao;
import com.demo.mpweb.domain.Book;
import com.demo.mpweb.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class bookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private bookDao _bookDao;

    @GetMapping("get")
    public String guestbook() {
        Book _book= bookService.getById(1);
        return _book.toString();
    }
    @GetMapping("getQueryList")
    public String getBookQueryList() {
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

        return list.toString();
    }


    @GetMapping("getPageList")
    public String guestBookPageList() {
        List<Book> list2=bookService.list();

        List<Book> list=bookService.getAll();
        System.out.println(list);
        return list.toString();
    }

    @PostMapping
    public Boolean saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }
    @PutMapping
    public Boolean updateBook(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBook(@PathVariable Integer id) {
        return bookService.removeById(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("/{currentPage}/pageSize")
    public IPage<Book> getPageList(@PathVariable int currentPage,@PathVariable int pageSize) {
        return bookService.getPage(1,5);
    }
}
