package com.bourntec.aaplearning.modules.invoicemanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Invoice;

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
public class InvoiceCustomResponseDto {
	String responseMessage;
	Object payload;
    String Status;
   
  //public InvoiceItemResponseDto(InvoiceItem invoice)
  //{
  //BeanUtils.copyProperties(invoice, this);
  //}


}
