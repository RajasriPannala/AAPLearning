package com.bourntec.aaplearning.modules.invoicemanagement.v1.response;





import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.DateFields;
import com.bourntec.aaplearning.entity.Invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {
	

String responsemessage;
Object payload;

String Status;
//private Integer invoiceId ;
//private Integer custId;
//private Integer orderId;
//private Integer itemCode;
//private  Integer invAmnt;
//private Integer paidAmnt;
//private  Integer retAmnt;

public InvoiceResponseDTO(Invoice invoice)
{
BeanUtils.copyProperties(invoice, this);
}


	 

}
