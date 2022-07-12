package com.bourntec.aaplearning.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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
	private String customerName;
	private Integer custId;
	private Integer itemCode;
	private String address;
	private Integer itemcount;
	
	 @JsonSerialize(using = LocalDateTimeSerializer.class)
	    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDate orderDate;
	private Integer trackingId;
	
	
	 @Column(length=1)
	    String orderStatus;


	

}
