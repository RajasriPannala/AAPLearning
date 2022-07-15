package com.bourntec.aaplearning.modules.commonmanagement.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.SmsRequest;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.impl.SmsServiceImpl;



/**
 * @author Allan George
 *
 */
@org.springframework.stereotype.Service
public class CustomService {

    private final SmsService smsSender;

    @Autowired
    public CustomService(@Qualifier("twilio") SmsServiceImpl smsServiceImpl) {
        this.smsSender = smsServiceImpl;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}