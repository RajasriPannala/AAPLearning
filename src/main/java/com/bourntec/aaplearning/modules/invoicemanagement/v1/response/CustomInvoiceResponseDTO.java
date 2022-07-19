package com.bourntec.aaplearning.modules.invoicemanagement.v1.response;

import java.util.List;

import com.bourntec.aaplearning.entity.Invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomInvoiceResponseDTO {
private List<Invoice> sort;
	
	private int totalPages;
	private int pageNumber;
	private int pageSize;
	
	



}
