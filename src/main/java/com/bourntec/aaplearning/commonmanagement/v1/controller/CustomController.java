package com.bourntec.aaplearning.commonmanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.aaplearning.commonmanagement.v1.service.CustomService;
import com.bourntec.aaplearning.commonmanagement.v1.service.EmailService;
import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;

@RestController
@RequestMapping("/custom")
public class CustomController {
	
	@Autowired 
	CustomService customService;
	
	@Autowired private 
	EmailService emailService;
	 
    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendSimpleMail(@RequestBody EmailRequestDTO details)
    {
       
            return emailService.sendSimpleMail(details);
 
       
    }
    
    @GetMapping("/{customerId}")
	public CustomerResponseDTO findById(@PathVariable int customerId)
	{
    	return customService.findById(customerId);
	}
 
	}



