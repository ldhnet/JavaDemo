package com.demo.mpweb.service;

import com.demo.mpweb.domain.Book;
import com.demo.mpweb.domain.SMSCode;

public interface ISMSCodeService {
    public String sendCodeToSMS(String tele);
    public Boolean checkCode(SMSCode smsCode);
}
