package com.bourntec.aaplearning.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 * @author Karthika J
 *
 */
@Configuration
	public class RestTemplateConfig {

	   
	    
	    /**
	     * common restTemplate to add headers
	     */
	    @Autowired
	    private HeaderInterceptor headerInterceptor;

	    @Bean
	    public RestTemplate restTemplate() {
	        RestTemplate restTemplate = new RestTemplate();

	        List<ClientHttpRequestInterceptor> interceptors
	          = restTemplate.getInterceptors();
	        if (CollectionUtils.isEmpty(interceptors)) {
	            interceptors = new ArrayList<>();
	        }
	        interceptors.add(headerInterceptor);
	        restTemplate.setInterceptors(interceptors);
	      
	        return restTemplate;
	    }
	}
	


