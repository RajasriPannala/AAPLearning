package com.bourntec.aaplearning.modules.invoicemanagement.v1.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.InvoiceItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Jeena Thomas
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceItemRequestDto {
	
	// private Integer Id;
	 private Integer invoiceId ;
	 private Integer itemCode;
	 private Integer itemCost;
	 private Integer itemCount;
	 
	 public InvoiceItem converToModel() {
		 InvoiceItem invoice=new InvoiceItem();

			BeanUtils.copyProperties(this, invoice);
			return invoice;

	}

}
