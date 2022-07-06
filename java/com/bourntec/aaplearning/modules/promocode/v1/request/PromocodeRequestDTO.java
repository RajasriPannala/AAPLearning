package com.bourntec.aaplearning.modules.promocode.v1.request;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Promocode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromocodeRequestDTO {
	
	private Integer promoCode;
	private LocalDate expiryDate;
	private String status;
	private double discount;
	private Integer minAmount;
	private double totalAmount;
	
	
	 public Promocode converToModel() {
		 Promocode promocode=new Promocode();

			BeanUtils.copyProperties(this, promocode);
			return promocode;

	}

}
