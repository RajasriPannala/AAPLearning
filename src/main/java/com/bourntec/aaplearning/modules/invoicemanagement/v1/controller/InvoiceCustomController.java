package com.bourntec.aaplearning.modules.invoicemanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceService;
@RestController

public class InvoiceCustomController {
	
	@Autowired
	InvoiceService invoiceService;
	@GetMapping("/download/csv")
	public void downloadAsCsv() {
		invoiceService.downloadAsCsv();
	}
}
