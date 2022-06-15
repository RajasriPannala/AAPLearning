package com.bourntec.aaplearning.modules.commonmanagement.v1.service;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;

public interface MailService {
	
	
	
	 String sendSimpleMail(EmailRequestDTO details);
	 String sendSimpleMails(EmailRequestDTO details);


}
