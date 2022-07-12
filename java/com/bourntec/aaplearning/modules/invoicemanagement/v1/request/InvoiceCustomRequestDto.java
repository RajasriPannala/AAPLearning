package com.bourntec.aaplearning.modules.invoicemanagement.v1.request;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Invoice;
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

public class InvoiceCustomRequestDto {
	private Integer invoiceId ;
	private Integer custId;
	private Integer orderId;
	private Integer itemCode;
	private  Integer invAmnt;
	private Integer paidAmnt;
	private  Integer retAmnt;
	private String status;
	private List<InvoiceItem> invoiceItem;
	
	public Invoice converToModel() {
		Invoice invoice=new Invoice();

			BeanUtils.copyProperties(this, invoice);
			return invoice;

	}

}
