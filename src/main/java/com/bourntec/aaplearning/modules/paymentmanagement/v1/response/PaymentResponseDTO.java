package com.bourntec.aaplearning.modules.paymentmanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {

	String responsemessage;
	Object payload;
	String status;

	public PaymentResponseDTO(Payment payment) {
		
		BeanUtils.copyProperties(payment, this);

	}

}
