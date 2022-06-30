package com.bourntec.aaplearning.modules.paymentmanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.service.CustomPaymentService;

@RestController

@RequestMapping("/custompayments")

public class CustomPaymentController {
	
	
	@Autowired
	CustomPaymentService custPaymentService;
	
	@PostMapping
	public ResponseEntity<PaymentResponseDTO> saveCustomPayment(@RequestBody PaymentRequestDTO paymentReqDTO) {

		PaymentResponseDTO payresDTO = custPaymentService.saveCustomPayment(paymentReqDTO);

		return ResponseEntity.ok(payresDTO);
	}


}
