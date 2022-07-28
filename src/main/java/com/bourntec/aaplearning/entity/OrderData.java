
package com.bourntec.aaplearning.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Karthika J
 *
 */
@Entity
@Table(name="orderData")

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//@Where(clause="order_id=:orderId")

public class OrderData extends DateFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)


	private Integer orderId;
	private Integer inventoryId;
	private Integer custId;
	private Integer itemCode;
	private String address;
	private Integer itemcount;
	private Integer totalPrice;
	private Double totalAmount;
	private Double discount;
	private Double amountPay;
	

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate orderDate;
	private Integer trackingId;
	
	
	@Column(length=1)
	String orderStatus;

}
