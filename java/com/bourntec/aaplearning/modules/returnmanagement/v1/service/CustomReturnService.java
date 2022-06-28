package com.bourntec.aaplearning.modules.returnmanagement.v1.service;

import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnResponseDTO;

public interface CustomReturnService {
	
	ReturnResponseDTO customSave(ReturnRequestDTO returnManagement);

}
