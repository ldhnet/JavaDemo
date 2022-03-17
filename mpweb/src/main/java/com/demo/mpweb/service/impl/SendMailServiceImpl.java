package com.demo.mpweb.service.impl;

import com.demo.mpweb.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.xml.soap.MimeHeader;
import java.io.File;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private  String from ="574427343@qq.com";

    private  String to ="lee.li@mkcorp.com";

    private  String imgUrl="<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161203%2F4678a4ec97e046b9ba8e4118be4902e9_th.jpg&refer=http%3A%2F%2Fimg.mp.itc.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1650077888&t=b20267d83e9c54f56123ad3436c1132e'>";


    private  String subject ="测试邮件标题";
    private  String context =String.format("测试邮件正文内容<a href='www.baidu.com'>点击跳转</a>;%s",imgUrl) ;

    @Override
    public void sendMail() {
        //        SimpleMailMessage message=new SimpleMailMessage();
        //        message.setFrom(from +"(小哥哥)");
        //        message.setTo(to);
        //        message.setSubject(subject);
        //        message.setText(context);
        //        javaMailSender.send(message);

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);//允许多附件
            helper.setFrom(from + "(小哥哥)");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context,true);

//            File f1=new File("D:\\JavaDemo\\JavaDemo\\mpweb\\target\\mpweb-0.0.1-SNAPSHOT.jar");
//            File f2=new File("D:\\JavaDemo\\JavaDemo\\mpweb\\mvnw.cmd");
//
//            helper.addAttachment("测试附件",f1);
//            helper.addAttachment(f2.getName(),f2);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
