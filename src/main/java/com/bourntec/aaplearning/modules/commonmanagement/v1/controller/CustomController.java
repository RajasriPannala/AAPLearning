package com.bourntec.aaplearning.modules.commonmanagement.v1.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.aaplearning.modules.commonmanagement.v1.request.SmsRequest;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.MailService;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.SmsService;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.impl.SmsServiceImpl;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomController {
	
	private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
	 
	@Autowired private 
	MailService emailService;
	@Autowired
	SmsService service;
	 
    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendSimpleMail(@RequestBody EmailRequestDTO details)
    {
        String status
            = emailService.sendSimpleMail(details);
 
        return status;
    }

    

    /**
     * @param mail
     * @return
     * @throws Exception
     */
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailRequestDTO mail) throws Exception {
    	String status
        = emailService.sendMailWithAttachment(mail);

        return status;
        }
//    @PostMapping("/sendTemplateMail")
//	public String sendEmailWithTemplate(@RequestBody EmailRequestDTO mail) {
//		return emailService.sendEmailWithTemplate(mail);
//
//	}
    
    @PostMapping("/sendSms")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {	
   

    	service.sendSms(smsRequest);
    	logger.info("SMS send successfully");
    	
    }
    

	@PostMapping("/sendTemplateMail")
	public String sendEmailWithTemplate(@RequestBody EmailRequestDTO mail) {
		return emailService.sendEmailWithTemplate(mail);

	}
}
