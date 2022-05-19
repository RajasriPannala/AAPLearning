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

	
	
    private Integer Itemcode;
	private String Specifiaction;
	private String Description;
	private String Manufacturer;
	private Integer Price;
	private Integer Discount;
	private String Pieces;
	
	public Inventory convertToModel() {
		
		Inventory inventory=new Inventory();
		
		BeanUtils.copyProperties(this,inventory);
		
		return inventory;
	}
}
