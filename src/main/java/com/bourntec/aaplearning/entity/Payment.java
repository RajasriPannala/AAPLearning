package com.bourntec.aaplearning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name="payment")

public class Payment extends DateFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	private Integer customerId;
	private Integer invoiceId;
	private Integer paidAmount;
	private String  status;
	private String paymentType;
	
	

}
