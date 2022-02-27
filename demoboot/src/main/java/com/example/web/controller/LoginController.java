package com.example.web.controller;

import com.example.mapper.SysUserMapper;
import com.example.web.models.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

public class LoginController {
    @Autowired
    private SysUserMapper userMapper;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("adduser")
    public String addUser(String username, String password, Model model){
        SysUser user=new SysUser();
        user.setUsername(username);
        //ByteSource bs=new SimpleByteSource("test".getBytes());
        SimpleHash hashedPassWord=new SimpleHash("MD5",password);
        String base64Pass = hashedPassWord.toHex();//转成16进制
        user.setPassword(base64Pass);
        user.setAge(20);
        user.setCreatetime(new Date());

        userMapper.addUser(user);
        model.addAttribute("msg","添加成功");
        return "user/add";
    }
    @RequestMapping("/loginprocess")
    public String loginProcess(String username, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        subject.login(token);
        model.addAttribute("msg","登陆成功");
        return "index";
    }
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
}
