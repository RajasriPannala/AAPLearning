package com.bourntec.aaplearning.modules.invoicemanagement.v1.request;

import javax.persistence.Column;


import org.springframework.beans.BeanUtils;


import com.bourntec.aaplearning.entity.Invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceRequestDTO {
	
	 private Integer invoiceId ;
	private Integer custId;
	private Integer orderId;
	private Integer itemCode;
	private  Integer invAmnt;
	private Integer paidAmnt;
	private  Integer retAmnt;
	 @Column(length=1)
	 private String status;
	 
	 public Invoice converToModel() {
		 Invoice invoice=new Invoice();

			BeanUtils.copyProperties(this, invoice);
			return invoice;

	}
}

