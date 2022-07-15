package com.bourntec.aaplearning.modules.invoicemanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceItemRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceItemService;

/**
 * @author Aryalekshmi
 *
 */
@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

	@Autowired
	InvoiceItemRepository invoiceitemRepository;
	Logger logger = LoggerFactory.getLogger(InvoiceItemServiceImpl.class);

	@Override
	public List<InvoiceItem> findAll() {
		return invoiceitemRepository.findAll();
	}

	/**
	 * delete invoice using invoice id
	 */
	@Override
	public InvoiceItemResponseDTO deleteById(int id) {
		InvoiceItemResponseDTO invoiceitemResponseDTO = new InvoiceItemResponseDTO();
		if (invoiceitemRepository.existsById(id) == true) {
			invoiceitemRepository.deleteById(id);
			invoiceitemResponseDTO.setResponsemessage("Deleted successfully");
			invoiceitemResponseDTO.setStatus("Sucess");
			logger.info("deleted");
			return invoiceitemResponseDTO;
		} else

			invoiceitemResponseDTO.setResponsemessage("Data not found");
		invoiceitemResponseDTO.setStatus("Failure");
		logger.error("User Not Found");
		return invoiceitemResponseDTO;
	}

	/**
	 * *save invoice details
	 */
	@Override
	public InvoiceItemResponseDTO save(InvoiceItemRequestDTO invoiceitemRequestDTO) {
		InvoiceItemResponseDTO invresDTO = new InvoiceItemResponseDTO();
		InvoiceItem invoiceitem = invoiceitemRequestDTO.converToModel();
		invoiceitem = invoiceitemRepository.save(invoiceitem);
		invresDTO.setPayload(invoiceitem);
		invresDTO.setResponsemessage(" data save sucessfully");
		invresDTO.setStatus("Sucess");
		logger.info("data saved successfully");
		return invresDTO;
	}

	/**
	 * update invoice details
	 */

	@Transactional(rollbackFor = Exception.class)
	public InvoiceItemResponseDTO updateById(Integer id, InvoiceItemRequestDTO invoiceitemRequestDTO) {
		InvoiceItemResponseDTO invresDTO = new InvoiceItemResponseDTO();
		Optional<InvoiceItem> invoiceOptional = invoiceitemRepository.findById(id);
		invoiceOptional.get();
		if (invoiceOptional.isPresent()) {
			InvoiceItem invoiceitem = invoiceitemRequestDTO.converToModel();
			invoiceitem.setInvoiceItemId(id);
			invoiceitemRepository.save(invoiceitem);
			invresDTO.setPayload(invoiceitem);
			invresDTO.setResponsemessage(" data save sucessfully");
			invresDTO.setStatus("Sucess");
			logger.info("data updated");
			return invresDTO;
		} else
			invresDTO.setResponsemessage(" id not present");
		invresDTO.setStatus("failed");
		logger.error("User Not Found");
		return invresDTO;
	}

	/**
	 * *find invoice using id
	 */

	@Override
	public InvoiceItemResponseDTO findById(int id) throws Exception {
		InvoiceItemResponseDTO invresDTO = new InvoiceItemResponseDTO();
		Optional<InvoiceItem> invoiceOptional = invoiceitemRepository.findById(id);
		if (invoiceOptional.isPresent()) {
			invresDTO.setPayload(invoiceOptional.get());
			invresDTO.setResponsemessage(" data got sucessfully");
			logger.info("Successfully fetched");
			invresDTO.setStatus("Sucess");
			return invresDTO;
		} else {
			invresDTO.setResponsemessage(" Given id does not exists");
			invresDTO.setStatus("failed");
			logger.error("User Not Found");
			return invresDTO;
		}
	}

	/**
	 * paging and sorting
	 */
	public List<InvoiceItem> getInvoiceItemList(int pageNo, Integer pageSize) {
		List<InvoiceItem> invoiceitemList = new ArrayList<InvoiceItem>();
		Sort custIdsort = Sort.by("itemCode").descending();
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<InvoiceItem> pagedResult = invoiceitemRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			invoiceitemList = pagedResult.getContent();
			return pagedResult.getContent();
		} else {
			return invoiceitemList;
		}

	}
}
