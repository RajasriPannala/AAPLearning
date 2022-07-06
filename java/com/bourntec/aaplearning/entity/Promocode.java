package com.bourntec.aaplearning.entity;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="promocode")
@EntityListeners(AuditingEntityListener.class)
@Data

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Promocode{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private Integer promoCode;
    @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	private String status;
	private double discount;
	private Integer minAmount;
//	private Integer totalAmount;
//	private Integer amountToPay;
}
