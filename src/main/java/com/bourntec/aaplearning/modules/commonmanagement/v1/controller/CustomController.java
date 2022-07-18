package com.bourntec.aaplearning.modules.commonmanagement.v1.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.MailService;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomController {

	@Autowired
	private MailService emailService;

	@Autowired
	RestTemplate restTemplate;

	// Sending a simple Email
	@PostMapping("/sendMail")
	public String sendSimpleMail(@RequestBody EmailRequestDTO details) {
		String status = emailService.sendSimpleMail(details);
return status;

	}

	@PostMapping("/sendTemplateMail")
	public String sendEmailWithTemplate(@RequestBody EmailRequestDTO mail) {
		return emailService.sendEmailWithTemplate(mail);

	}
}
