/**
 * 
 */
package com.bourntec.aaplearning.modules.invoicemanagement.v1.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.InvoiceItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aryalekshmi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemRequestDTO 
   {
	 
	 private Integer invoiceId;
	 private Integer itemCode;
	 private Integer quantity;
	 private Integer price;
	 private Integer total;
	 
	 public InvoiceItem converToModel()	
	 {
		 InvoiceItem invoiceItem=new InvoiceItem();
		 BeanUtils.copyProperties(this, invoiceItem);
		 return invoiceItem;

	 }

   }
