package com.demo.mpweb.service.impl;

import com.demo.mpweb.domain.SMSCode;
import com.demo.mpweb.service.ISMSCodeService;
import com.demo.mpweb.controller.ulits.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class SMSCodeServiceImpl implements ISMSCodeService {

    @Autowired
    private CodeUtils codeUtils;
    @Autowired
    private MemcachedClient memcachedClient;
    /*
    获取验证码
     */
//    @Override
//    //@Cacheable(value = "smsCode",key = "#tele")
//    @CachePut(value = "smsCode", key = "#tele")
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        return code;
//    }
//
//    @Override
//    public Boolean checkCode(SMSCode smsCode) {
//        String code = smsCode.getCode();
//        String codeCache = codeUtils.get(smsCode.getTele());
//        return code.equals(codeCache);
//    }

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele,10,code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return code;
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        String codeCache=null;
        try {
            codeCache = memcachedClient.get(smsCode.getTele()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(codeCache);
    }
}
