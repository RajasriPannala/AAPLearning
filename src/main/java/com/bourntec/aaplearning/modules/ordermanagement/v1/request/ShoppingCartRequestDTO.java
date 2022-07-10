package com.bourntec.aaplearning.modules.ordermanagement.v1.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.ShoppingCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Aryalekshmi
 *
 */


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartRequestDTO {
	
	private Integer inventoryId;
	private Integer customerId;
	private Integer itemCount;
	
	
	public ShoppingCart convertToModel() {
			
		ShoppingCart shoppingCart=new ShoppingCart();
		BeanUtils.copyProperties(this, shoppingCart);
		return shoppingCart;

	}
}
