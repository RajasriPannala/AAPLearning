package com.bourntec.aaplearning.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Aryalekshmi
 *
 */




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor	
@Table(name="merchandise")
public class Merchandise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	private String custId;
	private String itemCode;
	private Integer qty;
	private Double price;
	private Double discount;
    LocalDate purchaseDate;
	private String status;
	
	
}