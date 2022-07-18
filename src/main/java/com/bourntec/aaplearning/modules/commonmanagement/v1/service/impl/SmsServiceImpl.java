package com.bourntec.aaplearning.modules.commonmanagement.v1.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.SmsRequest;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.SmsService;
import com.twilio.type.PhoneNumber;



/**
 * @author Allan George
 *
 */
@Service("twilio")
public class SmsServiceImpl implements SmsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SmsServiceImpl.class);


	    @Override
	    public void sendSms(SmsRequest smsRequest) {
	    	
	        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
	            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
	            PhoneNumber from = new PhoneNumber("+18312734961");
	            String message = smsRequest.getMessage();
	            MessageCreator creator = Message.creator(to, from, message);
	            creator.create();
	            LOGGER.info("Send sms {}", smsRequest);
	        } else {
	            throw new IllegalArgumentException(
	                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
	            );
	        }

	    }

	    private boolean isPhoneNumberValid(String phoneNumber) {
	        // TODO: Implement phone number validator
	        return true;
	    }

}

