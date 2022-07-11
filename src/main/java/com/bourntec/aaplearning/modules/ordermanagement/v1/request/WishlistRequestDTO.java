package com.bourntec.aaplearning.modules.ordermanagement.v1.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Wishlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Karthika J
 *
 */


@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistRequestDTO {
	
	private Integer id;
	private Integer inventoryId;
	private Integer customerId;
	
	  public Wishlist convertToModel() {
			
		  Wishlist wishlist=new Wishlist();

			BeanUtils.copyProperties(this, wishlist);
			return wishlist;

}
}
