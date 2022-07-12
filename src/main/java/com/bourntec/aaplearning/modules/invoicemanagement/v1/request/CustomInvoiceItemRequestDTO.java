package com.bourntec.aaplearning.modules.invoicemanagement.v1.request;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.InvoiceItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Karthika J
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomInvoiceItemRequestDTO {

	private Integer invoiceId;
	private Integer itemCode;
	private Integer quantity;
	private Integer price;
	private Integer total;
	private List<InvoiceItem> invoiceItemList;

	public Invoice converToModel() {
		Invoice invoice = new Invoice();
		BeanUtils.copyProperties(this, invoice);
		return invoice;

	}

}
