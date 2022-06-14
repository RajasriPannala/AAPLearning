package com.bourntec.aaplearning.modules.commonmanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.MailService;

@RestController
public class CoustmController {
	
	
	@Autowired private 
	MailService emailService;
	 
    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailRequestDTO details)
    {
        String status
            = emailService.sendSimpleMail(details);
 
        return status;
    }
 
	}


