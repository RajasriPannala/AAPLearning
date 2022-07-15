package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	Logger logger = LoggerFactory.getLogger(ReturnServiceImpl.class);
	@Autowired
	ReturnRepository returnRepository;
	
	RestTemplate restTemplate;

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

	Return returnValue = returnRequestDTO.convertToModel();
	returnValue.setStatus(Constants.ACTIVE);
	returnValue = returnRepository.save(returnValue);

	retresDTO.setPayload(returnValue);
	retresDTO.setResponsemessage("Data save sucessfully");
	retresDTO.setStatus("Success");
	logger.info("data saved successfully");
	return retresDTO;
	}

	
	public ReturnResponseDTO deleteById(Integer id) {
		ReturnResponseDTO returnResponseDTO = new ReturnResponseDTO();

	if (returnRepository.existsById(id) == true) {
		returnRepository.deleteById(id);
		returnResponseDTO.setResponsemessage("Deleted successfully");

		returnResponseDTO.setStatus("Success");
		logger.info("data deleted successfully");
	return returnResponseDTO;
	} else

		returnResponseDTO.setResponsemessage("Data not found");
	returnResponseDTO.setStatus("Failure");
	logger.info("data not found");
	return returnResponseDTO;


	}
	/**
	 *
	 */
	public ReturnResponseDTO updateById(Integer id, ReturnRequestDTO returnRequestDTO) {
		ReturnResponseDTO retresDTO=new ReturnResponseDTO();
		Optional<Return> returnOptional = returnRepository.findById(id);
		if (returnOptional.isPresent()) {
			Return foundReturn = returnOptional.orElseThrow(() -> null);
			
			returnRequestDTO.setReturnId(id);
			Return returnManagement= returnRequestDTO.convertToModel(foundReturn);
			foundReturn.setReturnId(id);
			//Return returnManagements= returnRequestDTO.convertToModel();
			
			//returnManagement.setReturnId(id);
			
			//Return existingreturnManagement = returnOptional.get();


		
		returnManagement.setReturnId(id);
		returnRepository.save(returnManagement);
		retresDTO.setPayload(returnManagement);
		retresDTO.setResponsemessage("Data updated sucessfully");
		retresDTO.setStatus("Sucess");
		logger.info("data updated successfully");
		return retresDTO;
		} else
		{
		retresDTO.setResponsemessage("invalid id");
		retresDTO.setStatus("failed");
		logger.info("id is invalid");
		return retresDTO;
		}

	}
	
	
	
	@Override
	public ReturnResponseDTO findById(int id) throws Exception {

	ReturnResponseDTO retresDTO=new ReturnResponseDTO();
	Optional<Return> returnOptional=returnRepository.findById(id);
	if(returnOptional.isPresent()) {

	retresDTO.setPayload(returnOptional.get());
	retresDTO.setResponsemessage(" data got sucessfully");
	retresDTO.setStatus("Success");
	logger.info("Successfull");
	return retresDTO;

	}
	else {
		retresDTO.setResponsemessage("invalid id");
		retresDTO.setStatus("failed");
		logger.info("failed");
		return retresDTO;
	}
	}


	
	
//	@Override
//	public String FindByRetAmt(int id) {
//
//		Optional<Return> returnOptional = returnRepository.findById(id);
//		if (returnOptional.isPresent()) {
//			int retAmnt = returnOptional.get().getRetAmt();
//			String category = null;
//			if (retAmnt < 2)
//				category = "below";
//			else if (retAmnt < 5)
//				category = "above";
//			else if (retAmnt < 10)
//				category = "high";
//			else
//				category = "equal";
//			return category;
//		} else {
//			throw new RecordNotFoundException("Record not found");
//		}
//		
//	
//	}
}

	


