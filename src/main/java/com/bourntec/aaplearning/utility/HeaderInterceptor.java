package com.bourntec.aaplearning.utility;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @author Karthika J
 *
 */

/**
 * interceptor to add the header before sending the request 
 *
 */
@Component
public class HeaderInterceptor implements ClientHttpRequestInterceptor {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().set("AUTHORIZATION", httpServletRequest.getHeader("AUTHORIZATION"));
		ClientHttpResponse response = execution.execute(request, body);
		
		return response;
	}
}
