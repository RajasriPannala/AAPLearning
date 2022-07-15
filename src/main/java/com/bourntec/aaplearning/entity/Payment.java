package com.bourntec.aaplearning.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bourntec.aaplearning.modules.paymentmanagement.v1.enumeration.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payment")

public class Payment extends DateFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	
	private Integer customerId;
	private Integer invoiceId;
	private Integer paidAmount;//tax+totalamount
	private String status;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
    private Integer tax;
    private Double totalAmount;
	//private String paymentType;
	
	
	/*
	 * @JoinColumn(name="customer_id") Customer customer;
	 */
	

    
   // cc 13%
   // upi 5
}
