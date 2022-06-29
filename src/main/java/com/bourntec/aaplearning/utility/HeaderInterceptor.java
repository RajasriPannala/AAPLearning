package com.bourntec.aaplearning.utility;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class HeaderInterceptor implements ClientHttpRequestInterceptor {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().set("AUTHORIZATION", httpServletRequest.getHeader("AUTHORIZATION"));
		ClientHttpResponse response = execution.execute(request, body);
		
//        org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
//        header.set("AUTHORIZATION", request.getHeader("AUTHORIZATION"));
//        header.set("AUTHORIZATION","hiii" );
		return response;
	}
}
