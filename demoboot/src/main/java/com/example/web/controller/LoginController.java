package com.example.web.controller;

import com.example.mapper.SysUserMapper;
import com.example.utils.DateUtils;
import com.example.web.models.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RequestMapping("/demo")
@Controller
public class LoginController {
    @Autowired
    private SysUserMapper userMapper;

    @RequestMapping("/index")
    public String index(Model model){
        Subject subject = SecurityUtils.getSubject();
        boolean isLogin=subject.isAuthenticated();
        if (isLogin)
        {
            model.addAttribute("username",subject.getSession().toString());
            model.addAttribute("pwd","已登录");
            model.addAttribute("msg","已登录");
            return "/demo/index";
        }
        return  "/demo/login";
    }
    @RequestMapping("/login")
    public String login(){
        return "/demo/login";
    }
    @RequestMapping("/register")
    public String register(){
        return "/demo/register";
    }
    @RequestMapping("adduser")
    public String addUser(String username, String password, Model model){
        SysUser _user= userMapper.selectUserById(1);
        SysUser user=new SysUser();
        user.setUsername(username);
        //ByteSource bs=new SimpleByteSource("test".getBytes());
        SimpleHash hashedPassWord=new SimpleHash("MD5",password);
        String base64Pass = hashedPassWord.toHex();//转成16进制
        user.setPassword(base64Pass);
        user.setAge(20);
        user.setCreatetime(new Date());
        user.setUpdatetime(DateUtils.getNowDate());
        userMapper.addUser(user);
        model.addAttribute("msg","添加成功");
        return "/demo/login";
    }
    @RequestMapping("/loginprocess")
    public String loginProcess(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        subject.login(token);
        return "/demo/index";
    }
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/demo/index";
    }
}
