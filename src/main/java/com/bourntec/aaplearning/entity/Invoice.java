package com.bourntec.aaplearning.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Esther Tomy
 *
 */

@Table(name="Invoice")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invoice extends DateFields {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer invoiceId ;
 private Integer custId;
 private Integer orderId;
 private Integer itemCode;
 private Integer invAmnt;
 private Integer paidAmnt;
 private Integer retAmnt;
 private String status;
 @JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate orderDate;
 
 
	

}
