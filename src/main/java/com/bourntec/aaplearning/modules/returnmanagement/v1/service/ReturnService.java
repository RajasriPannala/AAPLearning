package com.bourntec.aaplearning.modules.returnmanagement.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Return;
import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnResponseDTO;

/**
 * @author Rohini P M
 *
 */
@Service
public interface ReturnService {
	
	

	ReturnResponseDTO save(ReturnRequestDTO returnManagement);

	ReturnResponseDTO deleteById(Integer id);

	ReturnResponseDTO updateById(Integer id ,ReturnRequestDTO returnReqDTO) ;
	
	ReturnResponseDTO findById(int id) throws Exception;
	
//	 String FindByRetAmt(int id);
	 void downloadAsCsv();

	/**
	 * @return
	 */
	List<Return> listAll();

}
