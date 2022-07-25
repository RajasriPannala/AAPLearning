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

import lombok.Data;

/**
 * @author Sarath G Krishnan
 *
 */
@Entity
@Table(name="returnList")
@EntityListeners(AuditingEntityListener.class)
@Data
public class ReturnList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer returnListId;
	private Integer itemCount;
	private Integer invoiceId;
	private Integer custId;
	private Integer itemCode;
	private Integer retAmt;
	private Integer qty;
	private String description;
	private String Status ;
	private Integer total;
	
	@JoinColumn(name = "returnId")
	 @ManyToOne(fetch = FetchType.EAGER)
	 private Return returnData;
}
