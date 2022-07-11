/**
 * 
 */
package com.bourntec.aaplearning.modules.returnmanagement.v1.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.ReturnItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bourntec
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnItemRequestDTO {
	
	private Integer id;
	private Integer returnId;
	private Integer itemCode;
	private Integer returnPrice;

	public ReturnItem converToModel(){
		ReturnItem returnItem=new ReturnItem();
		BeanUtils.copyProperties(this, returnItem);
		return returnItem;
	 }
}
