package com.bourntec.aaplearning.commonmanagement.v1.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;

@FeignClient(name = "simple-client", url = "http://localhost:8086/customers")
public interface CustomService {
	
	@GetMapping("/{customerId}")
	public CustomerResponseDTO findById(@PathVariable int customerId);

}
