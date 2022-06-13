package org.ldh.mybatisdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.ldh.mybatisdemo.domain.SysUser;
import org.ldh.mybatisdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class SysUserController {
    @Autowired
    private IUserService userInterface;
    @GetMapping("/all")
    public List<SysUser>  getAll() {
        log.error("测试");
        List<SysUser> sysUsers = userInterface.selectUserList();
        return sysUsers;
    }
}
