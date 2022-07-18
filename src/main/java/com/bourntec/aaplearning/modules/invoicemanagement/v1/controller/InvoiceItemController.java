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
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.CustomInvoiceResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceItemService;

/**
 * @author Aryalekshmi
 *
 */
@RestController 
@RequestMapping("/invoiceitem")
public class InvoiceItemController 
{
	@Autowired
	InvoiceItemService invoiceItemService;
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
	public InvoiceItemResponseDTO delete(@PathVariable int id) 
	{
	return invoiceItemService.deleteById(id);
	}
	/**
	 * @param id
	 * @param invoice
	 * @throws Exception
	 */
	@PutMapping("/{invoiceitemId}")
	public InvoiceItemResponseDTO updateById(@PathVariable Integer invoiceitemId, @RequestBody InvoiceItemRequestDTO invoiceitemRequestDTO) throws Exception {
		 return invoiceItemService.updateById(invoiceitemId,invoiceitemRequestDTO);
	}


	/**
	 * @param invoice
	 * @return
	 */
	@PostMapping
	public ResponseEntity<InvoiceItemResponseDTO> save(@RequestBody InvoiceItemRequestDTO invoiceitemRequestDTO) {

		InvoiceItemResponseDTO invoiceitemResDTO=invoiceItemService.save(invoiceitemRequestDTO);

		return ResponseEntity.ok(invoiceitemResDTO);
}
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public InvoiceItemResponseDTO get(@PathVariable int id) throws Exception {
		
	return invoiceItemService.findById(id);

	}
	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/invoiceitem/{pageNo}")

	public List<InvoiceItem> getInvoiceItemList(@PathVariable("pageNo")int pageNo, Integer pageSize){
		pageSize=5;

		 List<InvoiceItem> invoiceitem = invoiceItemService.getInvoiceItemList(pageNo-1,pageSize);
		return invoiceitem;

	}
	@GetMapping("/invoiceitem2")
	public InvoiceItemResponseDTO getCountInvoiceItemCode()
	{
		
		return invoiceItemService.getCountInvoiceItemCode();
	}
	@GetMapping("/invoicesoldandunsolditemcount")
	public InvoiceResponseDTO getCountInvoiceItemUnsoldAndSoldCodeCount()
	{
		
		return invoiceItemService.getCountInvoiceItemUnsoldAndSoldCodeCount();
	}
}

