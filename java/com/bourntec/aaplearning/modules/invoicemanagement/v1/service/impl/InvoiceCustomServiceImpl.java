package com.bourntec.aaplearning.modules.invoicemanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceItemRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceCustomRequestDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceCustomResponseDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceCustomService;
/**
 * @author Jeena Thomas
 *
 */

@Service
public class InvoiceCustomServiceImpl implements InvoiceCustomService {
	@Autowired
	InvoiceRepository invoiceRepository;
	Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

	@Autowired
	InvoiceItemRepository invoiceItemRepository;

	/**
	 *This method is to save data
	 * */
	@Override
	public InvoiceCustomResponseDto save(InvoiceCustomRequestDto invoiceCustomRequestDTO) {
		// TODO Auto-generated method stub
		InvoiceCustomResponseDto invresDTO=new InvoiceCustomResponseDto();

		Invoice invoice= invoiceCustomRequestDTO.converToModel();
		//invoice.setStatus(Constants.ACTIVE);
		invoice = invoiceRepository.save(invoice);
		List<InvoiceItem> invoiceItemList=new ArrayList<>();
		InvoiceItem invoiceItem=null;
		//InvoiceCustomRequestDto invoiceCustomRequestDto=new InvoiceCustomRequestDto();
		//List<InvoiceCustomRequestDto> invoiceCustomRequestDto=new ArrayList<InvoiceCustomRequestDto>();
		for(InvoiceItem invoiceItemDTO:invoiceCustomRequestDTO.getInvoiceItem() )
		{
			invoiceItemDTO.setInvoice(invoice);
			 invoiceItem = invoiceItemRepository.save(invoiceItemDTO);
		}
	  
		invresDTO.setPayload(invoiceCustomRequestDTO);
		invresDTO.setResponseMessage(" data save sucessfully");
		invresDTO.setStatus("Sucess");
		logger.info("data saved successfully");
		return invresDTO;
		}
	}
	

	