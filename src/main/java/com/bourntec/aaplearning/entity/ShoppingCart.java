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
 * @author Bourntec
 *
 */

@Getter
@Setter
@Entity
@Table(name="shoppingcart")
public class ShoppingCart
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer inventoryId;
	private Integer customerId;
	private Integer itemCount;

}
