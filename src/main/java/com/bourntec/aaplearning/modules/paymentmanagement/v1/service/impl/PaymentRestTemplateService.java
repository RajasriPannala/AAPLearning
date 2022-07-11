/**
 * 
 */
package com.bourntec.aaplearning.modules.paymentmanagement.v1.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author Karthika J
 *
 */
@Configuration
@EnableRetry
public class PaymentRestTemplateService {
	
	
	
	@Bean
	 public RetryTemplate retryTemplate() {
		 
		         SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		 
		         retryPolicy.setMaxAttempts(5);
		 
		 
		         FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
		 
		         backOffPolicy.setBackOffPeriod(1000);
		 
		 
		         RetryTemplate template = new RetryTemplate();
		 
		         template.setRetryPolicy(retryPolicy);
		 
		         template.setBackOffPolicy(backOffPolicy);
		 
		 
		         return template;
		 
		     }
	
		

}
