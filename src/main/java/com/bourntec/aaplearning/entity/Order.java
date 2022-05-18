package com.bourntec.aaplearning.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Karthika J
 *
 */
@Entity
@Table(name="orderManagement")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor


public class Order extends DateFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)


	private Integer orderId;
	private Integer custId;
	private Integer itemCode;
	private String address;
	private Integer itemcount;
	private LocalDate orderDate;
	private Integer trackingId;
	
	
	 @Column(length=1)
	    String orderStatus;


	

}
