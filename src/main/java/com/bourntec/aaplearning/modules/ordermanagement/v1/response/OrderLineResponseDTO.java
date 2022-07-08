package com.bourntec.aaplearning.modules.ordermanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.OrderLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineResponseDTO {

	
	String responseMessage;
	Object paylod;
//	String status;
	
	public  OrderLineResponseDTO(OrderLine orderLine)  {

		
		paylod=orderLine;
		responseMessage="data saved succefully";
	}
}
