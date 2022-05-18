package com.bourntec.aaplearning.modules.ordermanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Karthika J
 *
 */

@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderResponseDTO {
	
	
	String responseMessage;
	Object paylod;
	String status;
	 
	 

		/**
		 * @param order : order
		 */
		public void OrderResponseDto(Order order)  {

			BeanUtils.copyProperties(order,this);
		}



	

	
}
