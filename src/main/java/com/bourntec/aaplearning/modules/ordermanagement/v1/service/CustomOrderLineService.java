package com.bourntec.aaplearning.modules.ordermanagement.v1.service;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.modules.ordermanagement.v1.request.CustomOrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.CustomOrderLineResponseDTO;

@Service
public interface CustomOrderLineService {

	CustomOrderLineResponseDTO save(CustomOrderLineRequestDTO customOrderRequestDTO);
//	CustomOrderLineResponseDTO save(CustomOrderLineRequestDTO customOrderLineRequestDTO);
	
//	List<CustomOrderLineResponseDTO> save(List<CustomOrderLineRequestDTO> orderLineList);
}
