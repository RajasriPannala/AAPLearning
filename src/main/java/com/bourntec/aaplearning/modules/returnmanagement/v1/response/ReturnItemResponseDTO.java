/**
 * 
 */
package com.bourntec.aaplearning.modules.returnmanagement.v1.response;

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
public class ReturnItemResponseDTO {
	String responsemessage;
	Object payload;
	String Status;

	public ReturnItemResponseDTO(ReturnItem returnItem){
		BeanUtils.copyProperties(returnItem, this);
	}

}
