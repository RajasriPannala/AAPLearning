package com.bourntec.aaplearning.modules.invoicemanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceItemService;

/**
 * @author Jeena Thomas
 *
 */
@RestController 
@RequestMapping("/invoiceitem")
public class InvoiceItemController {
	
	@Autowired
	InvoiceItemService invoiceItemService;

	/**
	 * @param invoice
	 * @return
	 */
	
	@PostMapping
	public ResponseEntity<InvoiceItemResponseDto> save(@RequestBody InvoiceItemRequestDto invoiceRequestDTO) {

		InvoiceItemResponseDto invoiceResDTO=invoiceItemService.save(invoiceRequestDTO);

		return ResponseEntity.ok(invoiceResDTO);
}
	/**
	 * @return
	 */
	@GetMapping
	public List<InvoiceItem> getAll() {
		
	return  invoiceItemService.findAll();

	}
	/**
	 * @param invoiceId
	 */
	@DeleteMapping("/{id}")
	public InvoiceItemResponseDto delete(@PathVariable int id) 
	{
	return invoiceItemService.deleteById(id);
	}
	/**
	 * @param id
	 * @param invoice
	 * @throws Exception
	 */
	@PutMapping("/{invoiceId}")
	public InvoiceItemResponseDto updateById(@PathVariable Integer invoiceId, @RequestBody InvoiceItemRequestDto invoiceItemRequestDTO) throws Exception {
		 return invoiceItemService.updateById(invoiceId,invoiceItemRequestDTO);
	}
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public InvoiceItemResponseDto get(@PathVariable int id) throws Exception {
		
	return  invoiceItemService.findById(id);

	}


}
