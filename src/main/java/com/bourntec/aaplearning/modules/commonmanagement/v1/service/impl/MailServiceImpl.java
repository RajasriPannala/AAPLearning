package com.bourntec.aaplearning.modules.commonmanagement.v1.service.impl;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Customer;
import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.entity.Shipping;
import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.MailService;
import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.util.Constants;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.response.ShippingResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import freemarker.template.Configuration;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	Configuration fmConfiguration;

	@Autowired
	RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	@CircuitBreaker(name = "getPaymentCB", fallbackMethod = "getPaymentFallback")
	public String sendSimpleMail(EmailRequestDTO details) {
//		RestTemplate restTemplate = new RestTemplate();

		Payment payments = new Payment();

		final ObjectMapper mapper = new ObjectMapper();
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getToMail());
			mailMessage.setSubject(details.getSubject());
			if (details.getModule().equalsIgnoreCase(Constant.PAYMENT)) {
				PaymentResponseDTO payrsdto = restTemplate.getForObject(
						"http://localhost:8087/v1/paymentmanagement/" + details.getKeyValue(), PaymentResponseDTO.class);

				Payment payment = mapper.convertValue(payrsdto.getPayload(), Payment.class);
				
				if (payment.getPaymentType() != null && payment.getPaidAmount() != null) {
				mailMessage.setText(details.getMessage() + payment.getPaymentType() + payment.getPaidAmount());
				
				javaMailSender.send(mailMessage);
				
				return "Mail Sent Successfully...";
				}
			}

			else if (details.getModule().equalsIgnoreCase(Constant.ORDERDATA)) {

				ResponseEntity<OrderResponseDTO> response = restTemplate.getForEntity(
						"http://localhost:8081/ordermanagement/v1/orders/" + details.getKeyValue(),
						OrderResponseDTO.class);

				OrderData orderData = mapper.convertValue(response.getBody().getPaylod(), OrderData.class);

				if (orderData.getAddress() != null && orderData.getOrderStatus() != null) {
					mailMessage.setText(details.getMessage() + orderData.getAddress() + orderData.getOrderStatus());

					javaMailSender.send(mailMessage);

					return "Mail Sent Successfully...";
				}
			}

			else if (details.getModule().equalsIgnoreCase(Constant.SHIPPING)) {

				HttpHeaders headers = new HttpHeaders();
				// headers.add("Authorization",
				// "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2NTUyNjQ3MjAsImlhdCI6MTY1NTE3OTgyMH0.nKeOMaqcxh_PAWr5b7nn02gYPrGpLDF6cLJhDkJEq7GqOXS9-C7enQdVI-atjgwIhqdbmGjkPWOkTjFaOk_l7A");

				headers.add("Authorization", httpServletRequest.getHeader("AUTHORIZATION"));

				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				headers.add("user-agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
				// HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
				HttpEntity<String> request = new HttpEntity<String>(headers);
				ResponseEntity<ShippingResponseDTO> response = restTemplate.exchange(
						"http://localhost:8081/shippings/" + details.getKeyValue(), HttpMethod.GET, request,
						ShippingResponseDTO.class);

				Shipping shipping = mapper.convertValue(response.getBody().getPayload(), Shipping.class);

				if (shipping.getCustId() != null && shipping.getDeliveryStatus() != null)
					mailMessage.setText(details.getMessage() + shipping.getShipDate() + shipping.getShipStatus());

				javaMailSender.send(mailMessage);

				return "Mail Sent Successfully...";

			}
		
		else if (details.getModule().equalsIgnoreCase(Constants.CUSTOMER)) {
		
             ResponseEntity<CustomerResponseDTO> response = restTemplate
                    .getForEntity("http://localhost:8080/customermanagement/v1/" + details.getKeyValue(), CustomerResponseDTO.class);

             Customer customer = mapper.convertValue(response.getBody().getPayLoad(), Customer.class);

            if (customer.getAddress() != null && customer.getName() != null) 
                mailMessage.setText(details.getMessage() + "Address:"+","+customer.getAddress() +"Name:"+","+ customer.getName());

                javaMailSender.send(mailMessage);
               return "Mail Sent Successfully...";
            }
        }


		catch (Exception e) {
			throw e;
		}
		return sender;
	}
	
	
	public String sendMailWithAttachment(EmailRequestDTO mail) throws Exception  {
		try {
		
		MimeMessage msg = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(mail.getToMail());
		helper.setFrom(sender);
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getContent());
		
		

		FileSystemResource file = new FileSystemResource(new File("D:\\orderdata.pdf"));
		 helper.addAttachment("Order data",file);
		 
		 
		 javaMailSender.send(msg);
		return "send mail attached with order data successfully";
		
		
	}
		catch (Exception e) {
			throw e;
		}
		
	}

	public String getPaymentFallback(Exception e) {
		logger.info("---RESPONSE FROM FALLBACK METHOD---");

		return "---RESPONSE FROM FALLBACK METHOD !---";




	}
	}
		





