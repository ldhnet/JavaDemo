package com.demo.mpweb;

import com.demo.mpweb.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JavaEmailTest {
    @Autowired

    private SendMailService sendMailService;
    @Test
    public  void  sendMail()
    {
        //发送邮件
        sendMailService.sendMail();
    }
}
