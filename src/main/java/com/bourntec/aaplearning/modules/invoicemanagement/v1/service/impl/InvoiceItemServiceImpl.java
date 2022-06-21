package com.bourntec.aaplearning.modules.invoicemanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceItemRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceItemService;
/**
 * @author Jeena Thomas
 *
 */
@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {
	Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);
	@Autowired
	InvoiceItemRepository invoiceItemRepository;
	
	
    @Autowired
	InvoiceRepository invoiceRepository;

	


	/**
	 *This method is for save
	 */
	@Override
	public InvoiceItemResponseDto save(InvoiceItemRequestDto invoiceItemRequestDto) {
		// TODO Auto-generated method stub
		
		InvoiceItemResponseDto invresDTO = new InvoiceItemResponseDto();
		try {
			

			InvoiceItem invoiceItem= invoiceItemRequestDto.converToModel();
			Optional<Invoice> invoice = invoiceRepository.findById(invoiceItemRequestDto.getInvoiceId());
			invoiceItem.setInvoice(invoice.get());
			invoiceItem = invoiceItemRepository.save(invoiceItem);
			invresDTO.setPayload(invoiceItem);
			invresDTO.setResponseMessage(" data save sucessfully");
			invresDTO.setStatus("Sucess");
			logger.info("data saved successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			invresDTO.setResponseMessage(" data not saved");
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
			invoiceItemResponseDto.setResponseMessage("Deleted successfully");
			//invoiceItemRepository.setStatus("Sucess");
		logger.info("deleted");
		return invoiceItemResponseDto;


		} else

			invoiceItemResponseDto.setResponseMessage("Data not found");
		invoiceItemResponseDto.setStatus("Failure");
			logger.error("User Not Found");
		return invoiceItemResponseDto;



		}




	/**
	 *This method is for update
	 */

	@Override
	public InvoiceItemResponseDto updateById(Integer itemId, InvoiceItemRequestDto invoiceItemRequestDTO) {
		// TODO Auto-generated method stub
		InvoiceItemResponseDto invresDTO=new InvoiceItemResponseDto();
			Optional<InvoiceItem> invoiceOptional = invoiceItemRepository.findById(itemId);
			if (invoiceOptional.isPresent()) {


			InvoiceItem invoiceItem= invoiceItemRequestDTO.converToModel();
			InvoiceItem existinginvoice = invoiceOptional.get();

			
			invoiceItem.setItemId(itemId);
			invoiceItemRepository.save(invoiceItem);
			invresDTO.setPayload(invoiceItem);
			invresDTO.setResponseMessage(" data updated sucessfully");
			logger.info("data updated");
			return invresDTO;
			} else

            invresDTO.setResponseMessage(" id not present");
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
			invresDTO.setResponseMessage(" data got sucessfully");
			logger.info("Successfully fetched");
			return invresDTO;
			
		}
		else {
			invresDTO.setResponseMessage(" Given id does not exists");
			invresDTO.setStatus("failed");
			logger.error("invoice item Not Found");
			return invresDTO;
		}
	}




	@Override
	public List<InvoiceItem> getAll() {
		// TODO Auto-generated method stub
		return invoiceItemRepository.findAll();
	}




	@Override
	public List<InvoiceItemResponseDto> saveAll(List<InvoiceItemRequestDto> invoiceItemRequestDTO) {
		// TODO Auto-generated method stub
		List<InvoiceItem> invoiceItemList=new ArrayList<>();
		InvoiceItem invoiceItem=null;
		InvoiceItemRequestDto invoiceItemRequestDto=new InvoiceItemRequestDto();
		for(InvoiceItemRequestDto invoiceItemDTO:invoiceItemRequestDTO )
		{

		Optional<Invoice> invoice = invoiceRepository.findById(invoiceItemDTO.getInvoiceId());
		invoiceItem=invoiceItemDTO.converToModel();
        invoiceItem.setInvoice(invoice.get());
        invoiceItemList.add(invoiceItem);
		}
        List<InvoiceItemResponseDto> res= invoiceItemRepository.saveAll(invoiceItemList).stream().
		map(InvoiceItemResponseDto::new).toList();
		return res;
}
	
	}






	

	


