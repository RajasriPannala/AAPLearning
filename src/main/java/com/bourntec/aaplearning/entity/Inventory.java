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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Allan George
 *
 */
@Entity
@Table(name="inventory")
@EntityListeners(AuditingEntityListener.class)
@Data

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private Integer Itemcode;
	private String Specifiaction;
	private String Description;
	private String Manufacturer;
	private Integer Price;
	private Integer Discount;
	private String Pieces;
	
}
