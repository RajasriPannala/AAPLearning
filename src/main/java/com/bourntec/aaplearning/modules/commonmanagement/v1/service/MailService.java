package com.bourntec.aaplearning.modules.commonmanagement.v1.service;

import javax.mail.MessagingException;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;

public interface MailService {

	String sendSimpleMail(EmailRequestDTO details);

	String sendMailWithAttachment(EmailRequestDTO mail) throws  Exception;

}

