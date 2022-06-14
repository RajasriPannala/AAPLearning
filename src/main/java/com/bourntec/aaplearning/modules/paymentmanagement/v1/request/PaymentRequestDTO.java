package com.bourntec.aaplearning.modules.paymentmanagement.v1.request;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	private Integer customerId;
	private Integer invoiceId;
	private Integer paidAmount;
	private String status;
	private String paymentType;
	LocalDate paymentDate;

	public Payment convertToModel() {
		Payment payment = new Payment();

		BeanUtils.copyProperties(this, payment);

		return payment;
	}

	

	}

