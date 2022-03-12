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

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private bookDao _bookDao;

    @GetMapping
    public OperationResult getAll() {
        return new OperationResult(true, bookService.list());
    }

    @PostMapping
    public OperationResult saveBook(@RequestBody Book book) {
        return new OperationResult(bookService.save(book));
    }

    @PutMapping
    public OperationResult updateBook(@RequestBody Book book) {
        return new OperationResult(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public OperationResult deleteBook(@PathVariable Integer id) {
        return new OperationResult(true, bookService.removeById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public OperationResult getPageList(@PathVariable int currentPage, @PathVariable int pageSize) {
        IPage<Book> list = bookService.getPage(currentPage, pageSize);
        return new OperationResult(true, list);
    }

    //    @GetMapping("/{id}")
    //    public OperationResult getById(@PathVariable Integer id) {
    //        Book model = bookService.getById(id);
    //        return new OperationResult(true,model);
    //    }
    @GetMapping("/{id}")
    public OperationResult getById(@PathVariable Integer id) {
        Book model = bookService.getById(id);
        return new OperationResult(true, model);
    }
}
