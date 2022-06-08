package com.bourntec.aaplearning.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Table(name="invoice_item")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data

public class InvoiceItem {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer Id;
 private Integer invoiceId ;
 private Integer itemCode;
 private Integer itemCost;
 private Integer itemCount;
 
 
	

}

