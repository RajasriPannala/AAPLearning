package com.bourntec.aaplearning.modules.ordermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.CustomOrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.CustomOrderLineResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderLineResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.CustomOrderLineService;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.OrderLineService;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.OrderService;



@RestController
@RequestMapping("/custom")


	

public class CustomOrderLineController {
	
	@Autowired
	
	CustomOrderLineService customOrderLineService;

//	@Autowired
//
//	OrderLineService orderLineService;

@PostMapping
public ResponseEntity<CustomOrderLineResponseDTO> save(@RequestBody CustomOrderLineRequestDTO customOrderRequestDTO) {

	CustomOrderLineResponseDTO customOrdersDTO = customOrderLineService.save(customOrderRequestDTO);

	return ResponseEntity.ok(customOrdersDTO);
}










	
	
}
