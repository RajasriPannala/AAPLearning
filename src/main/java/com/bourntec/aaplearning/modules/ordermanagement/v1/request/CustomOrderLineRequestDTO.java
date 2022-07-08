package com.bourntec.aaplearning.modules.ordermanagement.v1.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.entity.OrderLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomOrderLineRequestDTO {

	
	
	private Integer orderId ;
	private Integer inventoryId;
	private Integer custId;
	private Integer itemcount;
	private Integer trackingId;
	
	
	private List<OrderLine> orderList;
		
	public  OrderData converToModel() {
		OrderData orderData=new OrderData();



	BeanUtils.copyProperties(this, orderData);
	return orderData;



	}
}
