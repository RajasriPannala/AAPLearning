package com.bourntec.aaplearning.modules.invoicemanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.CustomInvoiceItemRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.CustomInvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.CustomInvoiceItemService;


/**
 * @author Karthika J
 *
 */

@RequestMapping("invoicemanagement/v1/customInvoiceItem")
@RestController
public class CustomInvoiceItemController {
	
	

	@Autowired
	CustomInvoiceItemService customInvoiceItemService;
	

	/**
	 * @param customInvoiceItemRequestDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<CustomInvoiceItemResponseDTO> save(
			@RequestBody CustomInvoiceItemRequestDTO customInvoiceItemRequestDTO) {

		CustomInvoiceItemResponseDTO customInvoiceItemDTO = customInvoiceItemService.save(customInvoiceItemRequestDTO);

		return ResponseEntity.ok(customInvoiceItemDTO);
	}

}
