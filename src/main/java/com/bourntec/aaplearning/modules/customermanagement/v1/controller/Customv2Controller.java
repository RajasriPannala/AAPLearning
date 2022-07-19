package com.bourntec.aaplearning.modules.customermanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.service.Customv2Service;


@RestController
@RequestMapping("/tracker")
public class Customv2Controller {
	
	@Autowired
	Customv2Service customService;

//	@GetMapping("/{userId}")	
//	public Customv2ResponseDTO getDetails(@PathVariable int custId) throws Exception {
//		return customService.getDetails(custId);
//		
//	}
//	
	
	
	@GetMapping("/{custId}")	
	public CustomerResponseDTO getDetails(@PathVariable int custId) throws Exception {
		return customService.getDetails(custId);
		
	}
	
	
	
	
	
}
