package com.bourntec.aaplearning.modules.invoicemanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceService;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.util.Constants;



@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	InvoiceRepository invoiceRepository;

//	@Override
//	public List<InvoiceResponseDTO> findAll() {
//	
//		return invoiceRepository.findAll();
//	}
//	

//	@Override
//	public void deleteById(int id) {
//
//		String result=null;
//		if(invoiceRepository.existsById(id)==true) {
//			invoiceRepository.deleteById(id);
//
//
//		result="successfully deleted";
//		}else {
//		result="value does not exist";
//
//		}
//		
//		}
//		
	@Override
	public InvoiceResponseDTO deleteById(int id) {
	InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();

	if (invoiceRepository.existsById(id) == true) {
	invoiceRepository.deleteById(id);
	invoiceResponseDTO.setResponsemessage("Deleted successfully");

	invoiceResponseDTO.setStatus("Sucess");
	return invoiceResponseDTO;


	} else

		invoiceResponseDTO.setResponsemessage("Data not found");
		invoiceResponseDTO.setStatus("Failure");
	return invoiceResponseDTO;



	}

//	@Override
//	public Invoice save(Invoice invoice) {
//
//	  return invoiceRepository.save(invoice);
//	}
	@Override
	public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
	InvoiceResponseDTO invresDTO=new InvoiceResponseDTO();

	Invoice invoice= invoiceRequestDTO.converToModel();
	invoice.setStatus(Constants.ACTIVE);
	invoice = invoiceRepository.save(invoice);
	invresDTO.setPayload(invoice);
	invresDTO.setResponsemessage(" data save sucessfully");
	invresDTO.setStatus("Sucess");
	return invresDTO;
	}



	/**
	 *
	 */
//	public Invoice updateById(Integer id, Invoice invoice) throws Exception {
//		// order.setId(id);
//		Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
//		if (invoiceOptional.isPresent()) {
//
//
//
//		Invoice existinginvoice = invoiceOptional.get();
//
//		invoice.setInvoiceId(id);
//		return invoiceRepository.save(invoice);
//
//
//
//		} else
//
//
//
//		throw new Exception("Exception");
//
//
//
//		}
	public InvoiceResponseDTO updateById(Integer id, InvoiceRequestDTO invoiceRequestDTO) {
		// order.setId(id);
		InvoiceResponseDTO invresDTO=new InvoiceResponseDTO();
		Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
		if (invoiceOptional.isPresent()) {


		Invoice invoice= invoiceRequestDTO.converToModel();
		Invoice existinginvoice = invoiceOptional.get();
//
//		invoice.setInvoiceId(id);
//		return invoiceRepository.save(invoice);

		
		invoice.setInvoiceId(id);
		invoiceRepository.save(invoice);
		invresDTO.setPayload(invoice);
		invresDTO.setResponsemessage(" data save sucessfully");
		invresDTO.setStatus("Sucess");
		return invresDTO;
		} else


		invresDTO.setResponsemessage(" id not present");
		invresDTO.setStatus("failed");
//		throw new Exception("Exception");
		return invresDTO;
		



		}
	
	


	
	@Override
	public InvoiceResponseDTO findById(int id) throws Exception  {
		// TODO Auto-generated method stub
		InvoiceResponseDTO invresDTO=new InvoiceResponseDTO();
		Optional<Invoice> invoiceOptional=invoiceRepository.findById(id);
		if(invoiceOptional.isPresent()) {
//			return new InvoiceResponseDTO(invoiceOptional.get());
			
			invresDTO.setPayload(invoiceOptional.get());
			invresDTO.setResponsemessage(" data got sucessfully");
			invresDTO.setStatus("Sucess");
			return invresDTO;
			
		}
		else {
			invresDTO.setResponsemessage(" Given id does not exists");
			invresDTO.setStatus("failed");
//			throw new Exception("Exception");
			return invresDTO;
		}
	}
//   public  List<InvoiceResponseDTO> findAll() {
//	   InvoiceResponseDTO invresDTO=  new InvoiceResponseDTO();
//	   invresDTO.setPayload(invoiceRepository.findAll());
//		invresDTO.setResponsemessage(" data got sucessfully");
//		invresDTO.setStatus("Sucess");
//	   return invresDTO.toList();
////		return (List<InvoiceResponseDTO>) invresDTO;
//   }





	

	

}
