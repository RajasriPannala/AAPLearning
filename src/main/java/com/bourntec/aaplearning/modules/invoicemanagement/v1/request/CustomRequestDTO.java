package com.bourntec.aaplearning.modules.invoicemanagement.v1.request;

import java.util.List;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.SortList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor

public class CustomRequestDTO extends InvoiceRequestDTO
{
	private List<Invoice> invoices;
	private List<SortList> sort;
	private Integer page;
	private Integer size;

	

}
