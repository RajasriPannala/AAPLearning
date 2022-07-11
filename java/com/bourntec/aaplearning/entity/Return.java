package com.bourntec.aaplearning.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Rohini P M
 *
 */
@Entity
@Table(name="returnManagement")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Return {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer returnId;
	
	private Integer itemCount;
	private Integer invoiceId;
	private Integer custId;
	private Integer itemCode;
	private Integer retAmt;
	private Integer qty;
	private String description;
	private String Status ;

		
	}
	

