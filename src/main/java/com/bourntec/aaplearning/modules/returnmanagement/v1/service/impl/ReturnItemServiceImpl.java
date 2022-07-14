/**
 * 
 */
package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bourntec.aaplearning.entity.ReturnItem;
import com.bourntec.aaplearning.modules.returnmanagement.v1.repository.ReturnItemRepository;
import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnItemRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnItemResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnItemService;

/**
 * @author Bourntec
 *
 */
@Service
//@Primary
public class ReturnItemServiceImpl implements ReturnItemService{
	


	@Autowired
	ReturnItemRepository returnItemRepository;
	Logger logger = LoggerFactory.getLogger(ReturnItemServiceImpl.class);

	@Override
	public List<ReturnItem> findAll() {
		return returnItemRepository.findAll();
	}

	/**
	 * delete invoice using invoice id
	 */
	@Override
	public ReturnItemResponseDTO deleteById(int id) {
		ReturnItemResponseDTO returnItemResponseDTO = new ReturnItemResponseDTO();
		if (returnItemRepository.existsById(id) == true) {
			returnItemRepository.deleteById(id);
			returnItemResponseDTO.setResponsemessage("Deleted successfully");
			returnItemResponseDTO.setStatus("Sucess");
			logger.info("deleted");
			return returnItemResponseDTO;
		} else {

			returnItemResponseDTO.setResponsemessage("Data not found");
			returnItemResponseDTO.setStatus("Failure");
			logger.error("User Not Found");
			return returnItemResponseDTO;
		}
	}

	/**
	 * *save invoice details
	 */
	@Override
	public ReturnItemResponseDTO save(ReturnItemRequestDTO returnItemRequestDTO) {
		ReturnItemResponseDTO returnItemDTO = new ReturnItemResponseDTO();
		ReturnItem returnItem = returnItemRequestDTO.converToModel();
		returnItem = returnItemRepository.save(returnItem);
		returnItemDTO.setPayload(returnItem);
		returnItemDTO.setResponsemessage(" data save sucessfully");
		returnItemDTO.setStatus("Sucess");
		logger.info("data saved successfully");
		return returnItemDTO;
	}

	/**
	 * update invoice details
	 */

	@Transactional(rollbackFor = Exception.class)
	public ReturnItemResponseDTO updateById(Integer id, ReturnItemRequestDTO returnItemRequestDTO) {
		ReturnItemResponseDTO returnItemDTO = new ReturnItemResponseDTO();
		Optional<ReturnItem> returnItemOptional = returnItemRepository.findById(id);
		returnItemOptional.get();
		if (returnItemOptional.isPresent()) {
			ReturnItem returnItem = returnItemRequestDTO.converToModel();
			returnItem.setId(id);
			returnItemRepository.save(returnItem);
			returnItemDTO.setPayload(returnItem);
			returnItemDTO.setResponsemessage(" data save sucessfully");
			returnItemDTO.setStatus("Sucess");
			logger.info("data updated");
			return returnItemDTO;
		} else {
			returnItemDTO.setResponsemessage(" id not present");
			returnItemDTO.setStatus("failed");
			logger.error("User Not Found");
			return returnItemDTO;
		}
	}

	/**
	 * *find invoice using id
	 */

	@Override
	public ReturnItemResponseDTO findById(int id) throws Exception {
		ReturnItemResponseDTO returnItemDTO = new ReturnItemResponseDTO();
		Optional<ReturnItem> invoiceOptional = returnItemRepository.findById(id);
		if (invoiceOptional.isPresent()) {
			returnItemDTO.setPayload(invoiceOptional.get());
			returnItemDTO.setResponsemessage(" data got sucessfully");
			logger.info("Successfully fetched");
			returnItemDTO.setStatus("Sucess");
			return returnItemDTO;
		} else {
			returnItemDTO.setResponsemessage(" Given id does not exists");
			returnItemDTO.setStatus("failed");
			logger.error("User Not Found");
			return returnItemDTO;
		}
	}

	/**
	 * paging and sorting
	 */
	public List<ReturnItem> getReturnItemList(int pageNo, Integer pageSize) {
		List<ReturnItem> returnItemList = new ArrayList<ReturnItem>();
		Sort custIdsort = Sort.by("itemCode").descending();
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<ReturnItem> pagedResult = returnItemRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			returnItemList = pagedResult.getContent();
			return pagedResult.getContent();
		} else {
			return returnItemList;
		}

	}


}
