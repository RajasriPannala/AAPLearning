package com.bourntec.aaplearning.modules.commonmanagement.v1.service;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;

public interface MailService {

	
	 String sendEmailWithTemplate(EmailRequestDTO mail);
	String sendSimpleMail(EmailRequestDTO details);
	

}

