package com.bourntec.aaplearning.modules.customermanagement.v1.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.service.Customv2Service;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Customv2ServiceImpl implements Customv2Service {

	@Autowired

	HttpServletRequest httpServletRequest;
	
	@Autowired
	
	RestTemplate restTemplate;

	@Override
	public CustomerResponseDTO getDetails(int custId) {
		
		final ObjectMapper mapper = new ObjectMapper();
		HttpEntity entity = null;
		
		ResponseEntity<String> decodeResponse=restTemplate.exchange( "http://localhost:8081/ordermanagement/v1/orders/custid/" + custId, HttpMethod.GET,entity, String.class);
        System.out.println(decodeResponse.getBody());
        
        
        
       
		JSONArray orderArray = new JSONArray ();
		
		JSONObject json = XML.toJSONObject(decodeResponse.getBody());
orderArray=json.getJSONObject("OrderResponseDTO").getJSONArray("payload");
	CustomerResponseDTO	customerResponseDTO = new CustomerResponseDTO();
	JSONObject output = new JSONObject ();
	output.put("order",orderArray);
//	customerResponseDTO.setPayLoad(orderArray.toString());
    
	ResponseEntity<String> decodeResponses=restTemplate.exchange( "http://localhost:8083/invoice/custid/" + custId, HttpMethod.GET,entity, String.class);
    System.out.println(decodeResponses.getBody());

    JSONArray invoiceArray = new JSONArray ();
	JSONObject jsons = XML.toJSONObject(decodeResponses.getBody());
invoiceArray=jsons.getJSONObject("InvoiceResponseDTO").getJSONArray("payload");
//CustomerResponseDTO	customerResponseDTOs = new CustomerResponseDTO();
//customerResponseDTOs.setPayLoad(invoiceArray.toString());
output.put("invoice",invoiceArray);
      customerResponseDTO.setPayLoad(output);
      
      return  customerResponseDTO;
	
	
	
	
	}	
	
	
	
	}
	