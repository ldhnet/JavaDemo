package com.demo.mpweb.service.impl;

import com.demo.mpweb.domain.SMSCode;
import com.demo.mpweb.service.ISMSCodeService;
import com.demo.mpweb.controller.ulits.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements ISMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    /*
    获取验证码
     */
    @Override
    //@Cacheable(value = "smsCode",key = "#tele")
    @CachePut(value = "smsCode", key = "#tele")
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        return code;
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        String codeCache = codeUtils.get(smsCode.getTele());
        return code.equals(codeCache);
    }
}
