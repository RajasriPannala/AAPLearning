package com.bourntec.aaplearning.entity;

import javax.persistence.*;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;



@Table(name="Invoice")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data

public class Invoice extends DateFields {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer invoiceId ;
 private Integer custId;
 private Integer orderId;
// @ManyToMany
//	@JoinTable(
//	name = "inventory", 
//	joinColumns = @JoinColumn(name = "id"), 
//	inverseJoinColumns = @JoinColumn(name = "item_code"))
 private Integer itemCode;
 private Integer invAmnt;
 private Integer paidAmnt;
 private Integer retAmnt;
 private String status;
 
	

}
