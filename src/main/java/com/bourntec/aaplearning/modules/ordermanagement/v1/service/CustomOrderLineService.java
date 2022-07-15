package com.bourntec.aaplearning.modules.ordermanagement.v1.service;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.modules.ordermanagement.v1.request.CustomOrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.CustomOrderLineResponseDTO;

/**
 * @author Rohini P M
 *
 */
@Service
public interface CustomOrderLineService {

	
	

	/**
	 * @param customOrderLineRequestDTO
	 * @return
	 */
	CustomOrderLineResponseDTO save(CustomOrderLineRequestDTO customOrderLineRequestDTO);
	

}

