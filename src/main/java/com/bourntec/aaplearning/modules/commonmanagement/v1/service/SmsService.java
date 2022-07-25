package com.bourntec.aaplearning.modules.commonmanagement.v1.service;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.SmsRequest;

public interface SmsService {
	
	void sendSms(SmsRequest smsRequest);
	
	

}
