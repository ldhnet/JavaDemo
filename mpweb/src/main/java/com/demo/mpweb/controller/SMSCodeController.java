package com.demo.mpweb.controller;

import com.demo.mpweb.domain.SMSCode;
import com.demo.mpweb.service.ISMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {
    @Autowired
    private ISMSCodeService smsCodeService;

    @GetMapping("#tele")
    public String getcode(String tele) {
        String code = smsCodeService.sendCodeToSMS(tele);
        return code;
    }

    @PostMapping
    public Boolean checkcode(SMSCode smsCode) {

        return smsCodeService.checkCode(smsCode);
    }
}
