package com.bourntec.aaplearning.commonmanagement.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.aaplearning.commonmanagement.v1.service.EmailService;
import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	// String url="http://localhost:8080/payments/ +payments.getPaymentId()

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendSimpleMail(EmailRequestDTO details) {
		RestTemplate restTemplate = new RestTemplate();

		
		 ObjectMapper mapper = new ObjectMapper();
		//ObjectMapper objectMapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getToMail());
			mailMessage.setSubject(details.getSubject());
			
			//if(details.getModule().equals(Type.PAYMENT) && details.getKeyValue()!=null )
			//{
			if (details.getModule().equalsIgnoreCase(Constant.PAYMENT)) {
				if(details.getKeyValue()!=null)

				
				{
				PaymentResponseDTO payrsdto = restTemplate.getForObject(
						"http://localhost:8081/payments/" + details.getKeyValue(), PaymentResponseDTO.class);
				if(payrsdto.getPayload()!=null)
				{
				Payment payment = mapper.convertValue(payrsdto.getPayload(), Payment.class);
				mailMessage.setText(details.getMessage() + payment.getPaymentType() + payment.getPaidAmount());
			}
				
			}
						javaMailSender.send(mailMessage);
			}		
			
			return "Mail Sent Successfully...";
			}
		

		catch (Exception e) {
			return  "Check the details";

		}
		}
	}



