package com.bourntec.aaplearning.modules.invoicemanagement.v1.service;


import java.util.List;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;


public interface CsvOperationService {
	List<Invoice> read(String fileName) throws Exception;
	
	void write(List<Invoice> invoiceList, String fileName) throws Exception;
	default String convertTocsv(Invoice invoice) {



		return new StringBuffer (invoice.getInvoiceId()).append(invoice.getCustId()).append(",")
		.append(invoice.getOrderId()).append(", ")
		.append(invoice.getItemCode()).append(",").append(invoice.getInvAmnt()).append(",").append(invoice.getPaidAmnt()).append(",")
		.append(invoice.getRetAmnt()).append(invoice.getStatus()).append("\n").toString();



		}
	
}
