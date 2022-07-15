package com.bourntec.aaplearning.modules.paymentmanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sandra Diraj
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentResponseDTO {
	/**
	 * fields for payment response DTO
	 *
	 */

	String responsemessage;
	Object payload;
	
	String status;

	public PaymentResponseDTO(Payment payment) {
		/**
		 * used BeanUtils copy properties
		 *
		 */
		
		BeanUtils.copyProperties(payment, this);

	}

}
