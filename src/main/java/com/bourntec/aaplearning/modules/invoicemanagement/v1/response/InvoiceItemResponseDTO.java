/**
 * 
 */
package com.bourntec.aaplearning.modules.invoicemanagement.v1.response;

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
//@Getter
//@Setter
public class InvoiceItemResponseDTO 
{
	String responsemessage;
	Object payload;

	String Status;
	//private Integer invoiceId;
	//private Integer itemCode;
	// private Integer quantity;
	 //private Integer price;
	 //private Integer total;

	public InvoiceItemResponseDTO(InvoiceItem invoiceitem)
	{
	BeanUtils.copyProperties(invoiceitem, this);
	}
}
