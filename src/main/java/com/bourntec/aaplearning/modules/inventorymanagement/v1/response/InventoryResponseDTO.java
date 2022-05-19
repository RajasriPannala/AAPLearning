package com.bourntec.aaplearning.modules.inventorymanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Allan George
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponseDTO {
	
	String responseMessage;
	Object paylod;
	String status;
	
	public void InventoryResponseDTO(Inventory inventory) {
		BeanUtils.copyProperties(inventory, this);
	}

}
