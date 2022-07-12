package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
import com.bourntec.aaplearning.modules.returnmanagement.v1.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Primary
public class CustomReturnServiceImpl {
	
	@Autowired
	ReturnRepository returnRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public ReturnResponseDTO customSave(ReturnRequestDTO returnRequestDTO) {
	ReturnResponseDTO retresDTO=new ReturnResponseDTO();

	Return returnValue = returnRequestDTO.convertToModel();

	returnValue = returnRepository.save(returnValue);
	
	final ObjectMapper mapper = new ObjectMapper(); 
	
	/*
	 * Invoice DB update method 
	 */
	 if(returnValue.getInvoiceId()!= null )
	 {
		InvoiceResponseDTO impResponse= restTemplate.getForObject("http://localhost:8085/invoice/"+returnValue.getInvoiceId(),InvoiceResponseDTO.class);
		
		
		Invoice invoice = mapper.convertValue(impResponse.getPayload(),Invoice.class);
		
		
		invoice.setPaidAmnt(returnValue.getRetAmt());
		
		
		
		
		HttpEntity<Invoice> requestEntity = new HttpEntity<>(invoice);
		HttpEntity<InvoiceResponseDTO> response = restTemplate.exchange("http://localhost:8085/invoice/"+returnValue.getInvoiceId(), HttpMethod.PUT, requestEntity,InvoiceResponseDTO .class);
		
	 }
		/*
		 * Inventory DB update method
		 */
	 if(returnValue.getReturnId()!= null )
	 {
		InventoryResponseDTO impResponse1= restTemplate.getForObject("http://localhost:8082/inventory/"+returnValue.getReturnId(),InventoryResponseDTO.class);
		
		Inventory inventory=mapper.convertValue(impResponse1.getPaylod(), Inventory.class);
		
		
		inventory.setItemCount(inventory.getItemCount() + returnValue.getItemCount());



		HttpEntity<Inventory> requestEntity1 = new HttpEntity<>(inventory);
		HttpEntity<InventoryResponseDTO> response1 = restTemplate.exchange("http://localhost:8082/inventory/"+returnValue.getReturnId(), HttpMethod.PUT, requestEntity1,InventoryResponseDTO .class);
	 }
		
		retresDTO.setPayload(returnValue);
		retresDTO.setResponsemessage("Data save sucessfully");
		retresDTO.setStatus("Success");
		return retresDTO;
		


}


	
	
}
