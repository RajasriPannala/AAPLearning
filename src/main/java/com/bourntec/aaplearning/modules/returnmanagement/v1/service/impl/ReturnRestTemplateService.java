
package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Allan George
 *
 */
@Configuration
public class ReturnRestTemplateService {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
