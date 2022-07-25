package com.bourntec.aaplearning.modules.commonmanagement.v1.service;

import java.io.IOException;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.SmsRequest;
import com.plivo.api.exceptions.PlivoRestException;

public interface PlivoSmsService {

	void sendingSms(SmsRequest smsRqst) throws IOException, PlivoRestException;
}
