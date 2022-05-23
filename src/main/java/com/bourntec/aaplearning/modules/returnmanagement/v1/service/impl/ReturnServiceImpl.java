package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Inventory;
import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.Return;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.InventoryResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.repository.ReturnRepository;
import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnService;
import com.bourntec.aaplearning.modules.returnmanagement.v1.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Rohini P M
 *
 */
@Service
public class ReturnServiceImpl implements ReturnService{
	
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
	
	
	final ObjectMapper mapper = new ObjectMapper(); 
/*
 * Invoice DB update method 
 */
	InvoiceResponseDTO impResponse= restTemplate.getForObject("http://localhost:8085/invoice/"+returnValue.getInvoiceId(),InvoiceResponseDTO.class);
	
	// Invoice invoice = (Invoice) impResponse.getInvpayload();

	Invoice invoice = mapper.convertValue(impResponse.getPayload(),Invoice.class);
	
	//Invoice[] invoices= restTemplate.getForObject("localhost:8082/invoice/save",Invoice[].class);
    //for(Invoice invoice:invoices) {
		
	//System.out.println(invoice);
	
	//Invoice invoice=restTemplate.getForObject("http://localhost:8085/invoice/save"+returnValue.getInvoiceId(), Invoice.class);
	
	invoice.setPaidAmnt(returnValue.getRetAmt());
	
	
	
	
	HttpEntity<Invoice> requestEntity = new HttpEntity<>(invoice);
	HttpEntity<InvoiceResponseDTO> response = restTemplate.exchange("http://localhost:8085/invoice/"+returnValue.getInvoiceId(), HttpMethod.PUT, requestEntity,InvoiceResponseDTO .class);
	
	
	/*
	 * Inventory DB update method
	 */
	
	InventoryResponseDTO impResponse1= restTemplate.getForObject("http://localhost:8082/inventory/"+returnValue.getReturnId(),InventoryResponseDTO.class);
	
	Inventory inventory=mapper.convertValue(impResponse1.getPaylod(), Inventory.class);
	
	//inventory.setPieces(returnValue.getQty());
	
	
	inventory.setItemCount(inventory.getItemCount() + returnValue.getItemCount());



	HttpEntity<Inventory> requestEntity1 = new HttpEntity<>(inventory);
	HttpEntity<InventoryResponseDTO> response1 = restTemplate.exchange("http://localhost:8082/inventory/"+returnValue.getReturnId(), HttpMethod.PUT, requestEntity,InventoryResponseDTO .class);
	
	//inventory.setItemCount(inventory.getItemCount() - orderData.getItemcount());
	
	
	retresDTO.setPayload(returnValue);
	retresDTO.setResponsemessage("Data save sucessfully");
	retresDTO.setStatus("Success");
	return retresDTO;
	}

	
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

	


