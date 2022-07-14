package com.bourntec.aaplearning.modules.ordermanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.ordermanagement.v1.request.CustomOrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.CustomOrderLineResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.CustomOrderLineService;



/**
 * @author Rohini P M
 *
 */
@RestController
@RequestMapping("/custom")


	

public class CustomOrderLineController {
	
	@Autowired
	
	CustomOrderLineService customOrderLineService;



/**
 * @param customOrderRequestDTO
 * @return
 */
@PostMapping
public ResponseEntity<CustomOrderLineResponseDTO> save(@RequestBody CustomOrderLineRequestDTO customOrderRequestDTO) {

	CustomOrderLineResponseDTO customOrdersDTO = customOrderLineService.save(customOrderRequestDTO);

	return ResponseEntity.ok(customOrdersDTO);
}










	
	
}
