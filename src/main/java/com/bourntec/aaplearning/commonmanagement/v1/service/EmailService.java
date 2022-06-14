package com.bourntec.aaplearning.commonmanagement.v1.service;

import com.bourntec.aaplearning.commonmanagement.v1.request.EmailRequestDTO;


public interface EmailService {
	

	 String sendSimpleMail(EmailRequestDTO details);
}
