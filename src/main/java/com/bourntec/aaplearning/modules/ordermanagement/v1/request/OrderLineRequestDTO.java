package com.bourntec.aaplearning.modules.ordermanagement.v1.request;

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
public class OrderLineRequestDTO {

	
	Integer orderLineId;
	private Integer orderId ;
//    private Integer itemCode;
//    private Integer itemcount;

	

	public  OrderLine converToModel() {
		OrderLine orderLine=new OrderLine();



	BeanUtils.copyProperties(this, orderLine);
	return orderLine;



	}
}
