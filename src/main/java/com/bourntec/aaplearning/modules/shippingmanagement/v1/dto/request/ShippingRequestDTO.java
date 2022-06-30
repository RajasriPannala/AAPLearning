package com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.request;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Shipping;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingRequestDTO {
	
	private Integer shippingId;
	private	 String shipStatus;
	private	 Integer invoiceId;
	private  Integer custId;
	private	LocalDate shipDate;
	
	private	String  deliveryStatus;
	
	  public Shipping convertToModel() {
Shipping shipping = new Shipping();
BeanUtils.copyProperties(this, shipping);
return shipping;

}
}