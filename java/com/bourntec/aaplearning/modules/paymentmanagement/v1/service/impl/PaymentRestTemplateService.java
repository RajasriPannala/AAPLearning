/**
 * 
 */
package com.bourntec.aaplearning.modules.paymentmanagement.v1.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Karthika J
 *
 */
@Configuration
public class PaymentRestTemplateService {
	
	@Bean
	RestTemplate restTemplate () {
		
		return new RestTemplate();
	}
	

}
