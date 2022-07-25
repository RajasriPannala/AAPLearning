package com.bourntec.aaplearning.modules.returnmanagement.v1.service;

import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnListRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnListResponseDTO;

/**
 * @author Sarath G Krishnan
 *
 */
public interface ReturnListService {
	
	ReturnListResponseDTO save(ReturnListRequestDTO ReturnListRequestDTO);


}
