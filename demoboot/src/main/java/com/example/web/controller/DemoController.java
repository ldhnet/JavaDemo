package com.example.web.controller;

import com.example.mapper.SysUserMapper;
import com.example.web.models.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/demo")
@Controller
@Slf4j
public class DemoController {
    @Autowired
    private  SysUserMapper SysUserMapper;

    @RequestMapping("/index")
    public String index() {
        SysUser _user=SysUserMapper.selectUserById(1);
        log.info(_user.getUsername());
        log.info(_user.getCreatetime().toString());
        log.info(_user.toString());
        return  "index";
    }
}
