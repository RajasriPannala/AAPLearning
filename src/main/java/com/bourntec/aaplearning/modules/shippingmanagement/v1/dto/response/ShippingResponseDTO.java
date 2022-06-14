package com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Shipping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShippingResponseDTO {
	String responseMessage;
	Object paylod;
	String status;

	public void ShippingResponseDTO(Shipping shipping) {

		BeanUtils.copyProperties(shipping, this);
	}

}
