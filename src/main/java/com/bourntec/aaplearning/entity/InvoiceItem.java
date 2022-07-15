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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Aryalekshmi
 *
 */
@Table(name="InvoiceItem")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 private Integer id;
	 private Integer invoiceItemId ;
	 private Integer itemCode;
	 private Integer quantity;
	 private Integer price;
	 private Integer total;
	 
	 @JoinColumn(name = "return_Id")
	 @ManyToOne(fetch = FetchType.EAGER)
	 private Return returnItem;
	 
	 @JoinColumn(name = "invoiceId")
	 @ManyToOne(fetch = FetchType.EAGER)
	 private Invoice invoice;
	  
}
