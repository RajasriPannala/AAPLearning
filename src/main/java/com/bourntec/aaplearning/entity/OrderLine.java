package com.bourntec.aaplearning.entity;

import javax.persistence.Column;
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


@Entity
@Table(name="orderLine")
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "OrderLineId")
	private Integer orderLineId;
	


	 
	  
	@JoinColumn(name = "order_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private OrderData orderData;
//	private Set<OrderData> orderData = new HashSet<>();
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable( name = "orderData", joinColumns = @JoinColumn(name = "order_id"),
	 * inverseJoinColumns = @JoinColumn(name = "orderLineId")) private
	 * Set<OrderLine> orderLine;
	 */
	

	
	
	
	
	
	
}
