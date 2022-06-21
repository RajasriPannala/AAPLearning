package com.bourntec.aaplearning.modules.invoicemanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceCustomRequestDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceCustomResponseDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceCustomService;
/**
 * @author Jeena Thomas
 *
 */
@RestController
@RequestMapping("/custominvoice")
public class InvoiceCustomController {
	
	@Autowired
	InvoiceCustomService invoiceCustomService;
	
	/**
	 * @param invoice
	 * @return
	 */
	
	
	@PostMapping
	public ResponseEntity<InvoiceCustomResponseDto> save(@RequestBody InvoiceCustomRequestDto invoiceCustomRequestDto) {

		InvoiceCustomResponseDto invoiceResDTO=invoiceCustomService.save(invoiceCustomRequestDto);

		return ResponseEntity.ok(invoiceResDTO);
}

}
