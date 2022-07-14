package com.bourntec.aaplearning.modules.commonmanagement.v1.controller;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.modules.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.aaplearning.modules.commonmanagement.v1.service.MailService;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomController {
	
	
	@Autowired private 
	MailService emailService;
	 
    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendSimpleMail(@RequestBody EmailRequestDTO details)
    {
        String status
            = emailService.sendSimpleMail(details);
 
        return status;
    }
    @PostMapping("/sendTemplateMail")
    public String sendEmailWithTemplate(@RequestBody EmailRequestDTO email)
    {
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	final ObjectMapper mapper = new ObjectMapper();
    	
    	Map<String, Object> templateData = new HashMap<>();
		templateData.put("name", "Customer");
		if (email.getModule().equalsIgnoreCase(Constant.INVOICE)) {

			ResponseEntity<InvoiceResponseDTO> response = restTemplate
					.getForEntity("http://localhost:8083//invoice/" + email.getKeyValue(), InvoiceResponseDTO.class);

			 Invoice invoices = mapper.convertValue(response.getBody().getPayload(), Invoice.class);
			

		
		List<String> invoice = Arrays.asList("custId:"+invoices.getCustId(), "orderId:"+invoices.getOrderId(),
				"itemCode:"+invoices.getItemCode(),"invAmnt:"+invoices.getInvAmnt(),"paidAmnt:"+invoices.getPaidAmnt());
		
		
		templateData.put("field1", "custId");
		templateData.put("field2", "orderId");
		templateData.put("field3", "itemcode");
		templateData.put("field4", "invAmnt");
		templateData.put("field5", "paidAmnt");
		templateData.put("field6", "Status");
		
		templateData.put("data1", invoices.getCustId());
		templateData.put("data2", invoices.getOrderId());
		templateData.put("data3", invoices.getItemCode());
		templateData.put("data4", invoices.getInvAmnt());
		templateData.put("data5", invoices.getPaidAmnt());
		templateData.put("data6", invoices.getStatus());
		
		
		templateData.put("teamMembers", invoice);
		templateData.put("location", "Thrissur");
		
		email.setModel(templateData);
		}
        return emailService.sendEmailWithTemplate(email);
		
    }

    /**
     * @param mail
     * @return
     * @throws Exception
     */
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailRequestDTO mail) throws Exception {
 
    
    String status
    = emailService.sendMailWithAttachment(mail);

    return status;
    }
	}


