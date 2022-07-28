/**
 * 
 */
package com.bourntec.aaplearning.modules.ordermanagement.v1.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Customer;
import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.OrderRepository;

import com.bourntec.aaplearning.modules.ordermanagement.v1.service.OrderPaymentMailService;
import com.fasterxml.jackson.databind.ObjectMapper;

import freemarker.template.Configuration;

/**
 * @author Aryalekshmi
 *
 */
@Service
@Primary
public class OrderPaymentMailServiceImpl implements OrderPaymentMailService{
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	Configuration fmConfiguration;

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	OrderRepository orderRepository;
	//@Autowired
	
	//Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${spring.mail.username}")
	private String sender;

	
	
	public String unpaidPaymentEmail() {
		String message = "fail";	
		try {
			final ObjectMapper mapper = new ObjectMapper();
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
				
			List<OrderData> orderList = orderRepository.findAll();
				
			for (OrderData orderData : orderList)
			{
					
				if(orderData.getAmountPay() < orderData.getTotalAmount())
				{
					CustomerResponseDTO customerResponse = restTemplate.getForObject("http://localhost:8082/customermanagement/v1/" + orderData.getCustId(), CustomerResponseDTO.class);
					Customer customer = mapper.convertValue(customerResponse.getPayLoad(), Customer.class);
		            mailMessage.setTo(customer.getEmail());
		            
		            
		mailMessage.setSubject("Payment is not completed...!!!");
		mailMessage.setText("Your orderId is : "+(orderData.getOrderId())+"\n"+"Totalamount is Rs : "+(orderData.getTotalAmount())+"\n"+"Please pay your balance amount Rs : "+(orderData.getTotalAmount()-(orderData.getAmountPay())));
					
					
					
					
					
					javaMailSender.send(mailMessage);
				}
			}
			message = "Mail Sent Successfully...";
			} 
		catch (Exception e) {
		}
		return message;
	}
}
	
		
