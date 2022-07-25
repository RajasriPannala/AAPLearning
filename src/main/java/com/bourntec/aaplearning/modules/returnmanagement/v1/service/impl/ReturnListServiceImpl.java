package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Return;
import com.bourntec.aaplearning.entity.ReturnList;

import com.bourntec.aaplearning.modules.returnmanagement.v1.controller.ReturnController;

import com.bourntec.aaplearning.modules.returnmanagement.v1.repository.ReturnListRepository;
import com.bourntec.aaplearning.modules.returnmanagement.v1.repository.ReturnRepository;
import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnListRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnListResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnListService;

/**
 * @author Sarath G Krishnan
 *
 */
@Service
public class ReturnListServiceImpl implements ReturnListService {

	@Autowired
	ReturnListRepository returnListRepository;

	@Autowired
	ReturnRepository returnRepository;

	Logger logger = LoggerFactory.getLogger(ReturnController.class);

	private Integer returnId;

	/**
	 *
	 */
	@Override
	public ReturnListResponseDTO save(ReturnListRequestDTO returnListRequestDTO) {

		ReturnListResponseDTO returnResponseDTO = new ReturnListResponseDTO();
		
		

		Return returnData = returnListRequestDTO.converToModel();

		Integer total = 0;

		/**
		 ** filter and null check**
		 */

		for (ReturnList returnlist : returnListRequestDTO.getReturnLst()) {
			if (returnlist.getRetAmt() > 0 && returnlist.getRetAmt() != null && returnlist.getItemCount() != null) {
				total += returnlist.getRetAmt() * returnlist.getItemCount();
				returnlist .setTotal(total);
			}
		}

		//returnData.setRetAmt(total);

		returnData = returnRepository.save(returnData);
		List<ReturnList> rtnList = returnListRequestDTO.getReturnLst();

		if (!rtnList.isEmpty()) {
			for (ReturnList returnDTO : returnListRequestDTO.getReturnLst()) {
				ReturnList returnlist = new ReturnList();
				returnDTO.setReturnData(returnData);
				returnlist = returnListRepository.save(returnDTO);

			}
		}
		returnResponseDTO.setPayload(returnListRequestDTO);
		returnResponseDTO.setResponsemessage("return data saved sucessfully");

		logger.info("order saved");

		return returnResponseDTO;
	}

}
