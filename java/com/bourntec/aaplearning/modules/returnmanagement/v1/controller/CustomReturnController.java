package com.bourntec.aaplearning.modules.returnmanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.CustomReturnService;

@RestController
@RequestMapping("/CustomReturn")
public class CustomReturnController {
	

	@Autowired
	CustomReturnService CustomReturnService;

	
	@PostMapping
	public ResponseEntity<ReturnResponseDTO> customSave(@RequestBody ReturnRequestDTO returnReqDTO) {

		ReturnResponseDTO retresDTO=CustomReturnService.customSave(returnReqDTO);

		return ResponseEntity.ok(retresDTO);
		}

}
