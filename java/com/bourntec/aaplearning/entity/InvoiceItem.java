package com.bourntec.aaplearning.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceCustomRequestDto;

import lombok.Data;

@Table(name="invoice_item")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class InvoiceItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Integer itemId;
private Integer inventoryId ;
 
 private Integer itemCode;
 private Integer itemCost;
 private Integer itemCount;
 
 @JoinColumn(name = "invoiceId")
 @ManyToOne(fetch = FetchType.EAGER)
 private Invoice invoice;



 



}