package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Return;
import com.bourntec.aaplearning.modules.returnmanagement.v1.repository.ReturnRepository;
import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnService;
import com.bourntec.aaplearning.modules.returnmanagement.v1.util.Constants;

/**
 * @author Rohini P M
 *
 */
@Service
public class ReturnServiceImpl implements ReturnService{
	
	@Autowired
	ReturnRepository returnRepository;

	/**
	 *
	 */
//	@Override
//	public List<Return> findAll() {
//		
//		return returnRepository.findAll();
//	}

	
	/**
	 *
	 */
	@Override
	public ReturnResponseDTO save(ReturnRequestDTO returnRequestDTO) {
	ReturnResponseDTO retresDTO=new ReturnResponseDTO();

	Return returnManagement = returnRequestDTO.convertToModel();
	returnManagement.setStatus(Constants.ACTIVE);
	returnManagement = returnRepository.save(returnManagement);
	retresDTO.setPayload(returnManagement);
	retresDTO.setResponsemessage("Data save sucessfully");
	retresDTO.setStatus("Success");
	return retresDTO;
	}

	/**
	 *
	 */
	public ReturnResponseDTO deleteById(Integer id) {
		ReturnResponseDTO returnResponseDTO = new ReturnResponseDTO();

	if (returnRepository.existsById(id) == true) {
		returnRepository.deleteById(id);
		returnResponseDTO.setResponsemessage("Deleted successfully");

		returnResponseDTO.setStatus("Success");
	return returnResponseDTO;
	} else

		returnResponseDTO.setResponsemessage("Data not found");
	returnResponseDTO.setStatus("Failure");
	return returnResponseDTO;



	}
	/**
	 *
	 */
	public ReturnResponseDTO updateById(Integer id, ReturnRequestDTO returnRequestDTO) {
		ReturnResponseDTO retresDTO=new ReturnResponseDTO();
		Optional<Return> returnOptional = returnRepository.findById(id);
		if (returnOptional.isPresent()) {

			Return returnManagement= returnRequestDTO.convertToModel();

		
		returnManagement.setReturnId(id);
		returnRepository.save(returnManagement);
		retresDTO.setPayload(returnManagement);
		retresDTO.setResponsemessage("Data updated sucessfully");
		retresDTO.setStatus("Sucess");
		return retresDTO;
		} else
		{
		retresDTO.setResponsemessage("invalid id");
		retresDTO.setStatus("failed");
		return retresDTO;
		}

	}
	
	/**
	 *
	 */
	@Override
	public ReturnResponseDTO findById(int id) throws Exception {

	ReturnResponseDTO retresDTO=new ReturnResponseDTO();
	Optional<Return> returnOptional=returnRepository.findById(id);
	if(returnOptional.isPresent()) {

	retresDTO.setPayload(returnOptional.get());
	retresDTO.setResponsemessage(" data got sucessfully");
	retresDTO.setStatus("Success");
	return retresDTO;

	}
	else {
		retresDTO.setResponsemessage("invalid id");
		retresDTO.setStatus("failed");
		return retresDTO;
	}
	}
}

	


