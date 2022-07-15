package com.bourntec.aaplearning.modules.ordermanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.OrderLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Rohini P M
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineResponseDTO {

	
	String responseMessage;
	Object paylod;

	
	/**
	 * @param orderLine : orderLine
	 */
	public  OrderLineResponseDTO(OrderLine orderLine)  {

		
		paylod=orderLine;
		responseMessage="data saved succefully";
	}
}
