package com.bourntec.aaplearning.modules.commonmanagement.v1.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.SmsRequest;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.PlivoSmsService;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageCreator;



@Service("plivo")
public class PlivoSmsServiceImpl implements PlivoSmsService{


	
	private static final Logger LOGGER = LoggerFactory.getLogger(PlivoSmsServiceImpl.class);
	@Override
	public void sendingSms(SmsRequest smsRqst) throws IOException, PlivoRestException {
		
		if (isPhoneNumberValid(smsRqst.getPhoneNumber())) {
			String to =  smsRqst.getPhoneNumber();
            String from = "919496188891";
            

        
            String message = smsRqst.getMessage();
            MessageCreator response = Message.creator( from,to,message);
            response.create();
           
			 LOGGER.info("Send sms {}", response);
        }
            else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRqst.getPhoneNumber() + "] is not a valid number"
            );
        }}

    
	
	
	private boolean isPhoneNumberValid(String phoneNumber) {

		return true;
	}
}


