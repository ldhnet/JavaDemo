package org.ldh.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.ldh.web.controller.ulits.OperationResult;
import org.ldh.web.dao.bookDao;
import org.ldh.web.domain.Book;
import org.ldh.web.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/books")
@Api(value = "图书信息", tags = {"图书信息接口"})
public class bookController {
    //private static final Logger log= LoggerFactory.getLogger(())
    @Autowired
    private IBookService bookService;
    @Autowired
    private bookDao _bookDao;

    @Value("${server.port}")
    private String _serverport;

    @GetMapping
    @ApiOperation("查询全部图书")
    public OperationResult getAll() {
        log.error("测试");
        return new OperationResult(200,bookService.list());
    }

    @PostMapping
    @ApiOperation("新增图书")
    public OperationResult saveBook(@RequestBody Book book) throws IOException {
        Boolean flag=bookService.save(book);
        if (book.getName().equals("123"))
        {
            flag=false;
            throw new IOException();
        }

        return new OperationResult(200,flag?"添加成功6^_^":"添加失败-_-");
    }

    @PutMapping
    @ApiOperation("修改图书")
    public OperationResult updateBook(@RequestBody Book book) {
        return new OperationResult(bookService.updateById(book)?200:400);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据ID查询图书")
    public OperationResult deleteBook(@PathVariable Integer id) {
        return new OperationResult(200,bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public OperationResult getById(@PathVariable Integer id) {
        System.out.println("hot deploy .....");
        System.out.println("hot deploy .....");
        System.out.println(_serverport);
        return new OperationResult(200,bookService.getById(id));
    }
    @GetMapping("/{currentPage}/{pageSize}")
    @ApiOperation("分页查询图书")
    public OperationResult getPageList(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        IPage<Book> page=  bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages())
        {
            page =bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new OperationResult(200,page);
    }

}
