package com.bourntec.aaplearning.modules.ordermanagement.v1.response;

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

public class ShoppingCartResponseDTO {
	
	
	private String status;
	private String responseMessage;
	private ShoppingCart payload;
	/**
	 * @param shoppingCaryt
	 */
	public void ShoppingCartResponseDto(ShoppingCart shoppingCart)  {
		BeanUtils.copyProperties(shoppingCart,this);
	}
	
}
