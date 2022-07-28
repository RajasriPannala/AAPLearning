/**
 * 
 */
package com.bourntec.aaplearning.modules.ordermanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.ordermanagement.v1.service.OrderPaymentMailService;

/**
 * @author Aryalekshmi
 *
 */
@RestController
@RequestMapping("orderpaymentmail")

public class OrderPaymentMailController {
	@Autowired
	OrderPaymentMailService orderpaymentmailservice;
	
	@PostMapping("/unpayment")
	public String unpaidPaymentEmail() 
	{
	String message = orderpaymentmailservice.unpaidPaymentEmail();
	return message;
	}
}

