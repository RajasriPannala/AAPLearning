package com.bourntec.aaplearning.modules.paymentmanagement.v1.request;

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
public class PaymentRequestDTO {

	private Integer customerId;
	private Integer invoiceId;
	private Integer paidAmount;
	private String status;
	private String paymentType;

	public Payment convertToModel() {
		Payment payment = new Payment();

		BeanUtils.copyProperties(this, payment);

		return payment;
	}

	

	}

