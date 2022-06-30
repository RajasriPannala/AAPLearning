package com.bourntec.aaplearning.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shipping")
public class Shipping extends  DateFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shippingId;
	private	 String shipStatus;
	private	 Integer invoiceId;
	private  Integer custId;
	private	LocalDate shipDate;
	private	String deliveryStatus;
}
