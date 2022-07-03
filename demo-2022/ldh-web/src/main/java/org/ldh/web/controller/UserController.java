package org.ldh.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ldh.web.controller.ulits.OperationResult;
import org.ldh.web.domain.User;
import org.ldh.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private IUserService userService;
    @RequestMapping("/queryUserByNameFuzzy")
    public OperationResult queryUserByNameFuzzy(String userName) throws Exception {
        List<User> users = userService.queryUserByName(userName);
        return new  OperationResult(200,users);
    }
    @GetMapping("/userPageListFuzzy")
    public OperationResult queryUserByNameFuzzy(int currentPage, int pageSize) throws Exception {
        IPage<User> pageList = userService.getUserPageList(currentPage, pageSize);
        return new  OperationResult(200,pageList.getRecords());
    }
    @GetMapping("/queryUserPageListFuzzy")
    public OperationResult queryUserByNameFuzzy(int currentPage, int pageSize, User user) throws Exception {
        IPage<User> pageList = userService.getQueryUserPageList(currentPage, pageSize, user);
        return new  OperationResult(200,pageList.getRecords());
    }

//    @RequestMapping("/queryUserByNameFuzzy")
//    public OperationResult queryUserByNameFuzzy(String userName) throws Exception {
//        List<User> users = mapper.readValue(str, new TypeReference<List<User>>() {
//        });
//        return new  OperationResult(true,users);
//    }
}

