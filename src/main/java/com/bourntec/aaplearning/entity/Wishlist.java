/**
 * 
 */
package com.bourntec.aaplearning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aryalekshmi
 *
 */


@Entity
@Setter
@Getter
@Table(name="wishlist")
public class Wishlist 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer inventoryId;
	private Integer customerId;
	 
	
	
	

}
