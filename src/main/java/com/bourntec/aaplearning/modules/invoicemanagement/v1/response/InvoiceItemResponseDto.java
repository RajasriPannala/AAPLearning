package com.bourntec.aaplearning.modules.invoicemanagement.v1.response;

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
public class InvoiceItemResponseDto {
	

String responsemessage;
Object payload;

String Status;

/**
 * @param invoice
 */
public InvoiceItemResponseDto(InvoiceItem invoice)
{
BeanUtils.copyProperties(invoice, this);
}


	 

}