package org.ldh.web.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.ldh.web.controller.ulits.OperationResult;
import org.ldh.web.dao.bookDao;
import org.ldh.web.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private bookDao _bookDao;

    @GetMapping
    public OperationResult getAll() {
        log.error("测试");
        return new OperationResult(true,bookService.list());
    }
}
