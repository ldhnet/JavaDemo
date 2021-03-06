package com.demo.mpweb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.mpweb.controller.ulits.OperationResult;
import com.demo.mpweb.dao.bookDao;
import com.demo.mpweb.domain.Book;
import com.demo.mpweb.service.IBookService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/books")
@Api(tags = "使用Swagger测试接口信息")  //这个总体接口的信息
public class bookController {
    //private static final Logger log= LoggerFactory.getLogger(())
    @Autowired
    private IBookService bookService;
    @Autowired
    private bookDao _bookDao;

    @Value("${server.port}")
    private String _serverport;

    @GetMapping
    public OperationResult getAll() {
        log.error("测试");
        return new OperationResult(true,bookService.list());
    }

    @PostMapping
    public OperationResult saveBook(@RequestBody Book book) throws IOException {
        Boolean flag=bookService.save(book);
        if (book.getName().equals("123"))
        {
            flag=false;
            throw new IOException();
        }

        return new OperationResult(flag,flag?"添加成功6^_^":"添加失败-_-");
    }

    @PutMapping
    public OperationResult updateBook(@RequestBody Book book) {
        return new OperationResult(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public OperationResult deleteBook(@PathVariable Integer id) {
        return new OperationResult(true,bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public OperationResult getById(@PathVariable Integer id) {
        System.out.println("hot deploy .....");
        System.out.println("hot deploy .....");
        System.out.println(_serverport);
        return new OperationResult(true,bookService.getById(id));
    }
    @GetMapping("/{currentPage}/{pageSize}")
    public OperationResult getPageList(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        IPage<Book> page=  bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages())
        {
            page =bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new OperationResult(true,page);
    }

}
