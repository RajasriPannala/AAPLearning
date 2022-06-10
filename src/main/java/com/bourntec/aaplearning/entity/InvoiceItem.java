package com.bourntec.aaplearning.entity;

import javax.persistence.*;


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
 
//@ManyToMany(fetch = FetchType.LAZY)
//@JoinTable(
//name = "inventory", 
//joinColumns = @JoinColumn(name = "id"), 
//inverseJoinColumns = @JoinColumn(name = "item_code"))
//inverseJoinColumns = @JoinColumn(name = "item_code"))
 private Integer itemCode;
 private Integer itemCost;
 private Integer itemCount;
 
 
 
 
	

}

