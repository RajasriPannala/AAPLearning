package com.bourntec.aaplearning.modules.commonmanagement.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.entity.Shipping;
import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.MailService;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.response.ShippingResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	// String url="http://localhost:8080/payments/ +payments.getPaymentId()

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendSimpleMail(EmailRequestDTO details) {
		RestTemplate restTemplate = new RestTemplate();

		Payment payments = new Payment();

		final ObjectMapper mapper = new ObjectMapper();
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getToMail());
			mailMessage.setSubject(details.getSubject());
			if (details.getModule().equalsIgnoreCase(Constant.PAYMENT)) {
				PaymentResponseDTO payrsdto = restTemplate.getForObject(
						"http://localhost:8081/payments/" + details.getKeyValue(), PaymentResponseDTO.class);
				Payment payment = mapper.convertValue(payrsdto.getPayload(), Payment.class);
				mailMessage.setText(details.getMessage() + payment.getPaymentType() + payment.getPaidAmount());
			}
						javaMailSender.send(mailMessage);
			
			return "Mail Sent Successfully...";

		}

		catch (Exception e) {
			throw e;

		}
	}
	
	public String sendSimpleMails(EmailRequestDTO details) {
		RestTemplate restTemplate = new RestTemplate();

		Shipping shippings = new Shipping();

		final ObjectMapper mapper = new ObjectMapper();
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getToMail());
			mailMessage.setSubject(details.getSubject());
			if (details.getModule().equalsIgnoreCase(Constant.PAYMENT)) {
				ShippingResponseDTO shypsdto = restTemplate.getForObject(
						"http://localhost:8081/shippings/" + details.getKeyValue(), ShippingResponseDTO.class);
				Shipping shipping = mapper.convertValue(shypsdto.getPayload(), Shipping.class);
				mailMessage.setText(details.getMessage() + shipping.getShipStatus() + shipping.getShipDate());
			}
						javaMailSender.send(mailMessage);
			
			return "Mail Sent Successfully...";

		}

		catch (Exception e) {
			throw e;

		}
	}
}
