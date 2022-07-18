package com.bourntec.aaplearning.modules.commonmanagement.v1.request;

import javax.validation.constraints.NotBlank;

import com.bourntec.aaplearning.entity.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Allan George
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsRequest {
	

   
     String phoneNumber; // destination

   
     String message;


}

 /*   @Override
    public String toString() {
    	
    	Customer cust = new Customer();
    	
    	
    	return "SmsRequest{" +
    	cust.getPhoneNumber() + '\'' +
                ", message='" +cust.getName()+ "Registered successfully" + '\'' +
                '}';
       
  	
    	/*return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
                */
    


