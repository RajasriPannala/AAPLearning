package com.bourntec.aaplearning.modules.ordermanagement.v1.request;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.OrderData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Karthika J
 *
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
	
	private Integer custId;
	private Integer itemCode;
	private String address;
	private Integer itemcount;
	private LocalDate orderDate;
	private Integer trackingId;
	
	private Double totalAmount;
	private Double discount;
	private Double amountPay;
	private String orderStatus;
	
	private double price;
	private  String currency;
	private  String method;
	private  String intent;
	private String description; 
	
	public OrderData convertToModel() {
		OrderData order=new OrderData();
		BeanUtils.copyProperties(this, order);
		return order;
	}
}
