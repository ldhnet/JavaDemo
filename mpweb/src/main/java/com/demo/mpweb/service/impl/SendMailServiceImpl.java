package com.demo.mpweb.service.impl;

import com.demo.mpweb.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private  String from ="574427343@qq.com";

    private  String to ="lee.li@mkcorp.com";
    private  String subject ="测试邮件标题";
    private  String context ="测试邮件正文内容";

    @Override
    public void sendMail() {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
