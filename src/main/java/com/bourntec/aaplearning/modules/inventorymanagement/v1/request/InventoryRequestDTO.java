package com.bourntec.aaplearning.modules.inventorymanagement.v1.request;

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
public class InventoryRequestDTO {

	
	
    private Integer itemCode;
    private Integer itemCount;
	private String specifiaction;
	private String description;
	private String manufacturer;
	private Integer price;
	private Integer discount;
	
	public Inventory convertToModel() {
		
		Inventory inventory=new Inventory();
		
		BeanUtils.copyProperties(this,inventory);
		
		return inventory;
	}
}
