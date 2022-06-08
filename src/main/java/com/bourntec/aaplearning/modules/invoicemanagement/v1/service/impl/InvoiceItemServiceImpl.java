package com.bourntec.aaplearning.modules.invoicemanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceItemRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceItemService;
/**
 * @author Jeena Thomas
 *
 */
@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {
	@Autowired
	InvoiceItemRepository invoiceItemRepository;
	Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

	

	


	/**
	 *This method is for save
	 */
	@Override
	public InvoiceItemResponseDto save(InvoiceItemRequestDto invoiceItemRequestDto) {
		// TODO Auto-generated method stub
		
		InvoiceItemResponseDto invresDTO = new InvoiceItemResponseDto();
		try {
			

			InvoiceItem invoiceItem= invoiceItemRequestDto.converToModel();
			invoiceItem = invoiceItemRepository.save(invoiceItem);
			invresDTO.setPayload(invoiceItem);
			invresDTO.setResponsemessage(" data save sucessfully");
			invresDTO.setStatus("Sucess");
			logger.info("data saved successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invresDTO;
		}




	/**
	 *This method is for find all data
	 */

	@Override
	public List<InvoiceItem> findAll() {
		// TODO Auto-generated method stub
		return invoiceItemRepository.findAll();
	
	}





	/**
	 *This method is for delete
	 */
	@Override
	public InvoiceItemResponseDto deleteById(int id) {
		// TODO Auto-generated method stub
		InvoiceItemResponseDto invoiceItemResponseDto = new InvoiceItemResponseDto();

		if (invoiceItemRepository.existsById(id) == true) {
			invoiceItemRepository.deleteById(id);
			invoiceItemResponseDto.setResponsemessage("Deleted successfully");
			//invoiceItemRepository.setStatus("Sucess");
		logger.info("deleted");
		return invoiceItemResponseDto;


		} else

			invoiceItemResponseDto.setResponsemessage("Data not found");
		invoiceItemResponseDto.setStatus("Failure");
			logger.error("User Not Found");
		return invoiceItemResponseDto;



		}




	/**
	 *This method is for update
	 */

	@Override
	public InvoiceItemResponseDto updateById(Integer invoiceId, InvoiceItemRequestDto invoiceItemRequestDTO) {
		// TODO Auto-generated method stub
		InvoiceItemResponseDto invresDTO=new InvoiceItemResponseDto();
			Optional<InvoiceItem> invoiceOptional = invoiceItemRepository.findById(invoiceId);
			if (invoiceOptional.isPresent()) {


			InvoiceItem invoiceItem= invoiceItemRequestDTO.converToModel();
			InvoiceItem existinginvoice = invoiceOptional.get();

			
			invoiceItem.setInvoiceId(invoiceId);
			invoiceItemRepository.save(invoiceItem);
			invresDTO.setPayload(invoiceItem);
			invresDTO.setResponsemessage(" data updated sucessfully");
			logger.info("data updated");
			return invresDTO;
			} else

            invresDTO.setResponsemessage(" id not present");
			logger.error("User Not Found");
			return invresDTO;
			

	}



	/**
	 *This method is for find data corresponding to given id
	 */


	@Override
	public InvoiceItemResponseDto findById(int id) {
		// TODO Auto-generated method stub
		InvoiceItemResponseDto invresDTO=new InvoiceItemResponseDto();
		Optional<InvoiceItem> invoiceOptional=invoiceItemRepository.findById(id);
		if(invoiceOptional.isPresent()) {

			
			invresDTO.setPayload(invoiceOptional.get());
			invresDTO.setResponsemessage(" data got sucessfully");
			logger.info("Successfully fetched");
			return invresDTO;
			
		}
		else {
			invresDTO.setResponsemessage(" Given id does not exists");
			invresDTO.setStatus("failed");
			logger.error("invoice item Not Found");
			return invresDTO;
		}
	}
	}






	

	


