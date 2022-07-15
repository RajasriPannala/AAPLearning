package com.bourntec.aaplearning.modules.ordermanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Wishlist;

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

public class WishlistResponseDTO {
	
	
	private String status;
	private String responseMessage;
	private Wishlist payload;
	 
	 
	/**
	 * @param order : order
	 */
	public void WishlistResponseDTO(Wishlist wishlist)  {
		BeanUtils.copyProperties(wishlist,this);
	}

}
