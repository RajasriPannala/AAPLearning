package com.bourntec.aaplearning.modules.invoicemanagement.v1.controller;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.CustomRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceDateSearchDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceService;



/**
 * @author Esther Tomy
 *
 */
@RestController 
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	/**
	 * @return
	 */
	@GetMapping
	public List<Invoice> getAll() {
		
	return  invoiceService.findAll();

	}
	/**
	 * @param invoiceId
	 */
	@DeleteMapping("/{id}")
	public InvoiceResponseDTO delete(@PathVariable int id) 
	{
	return invoiceService.deleteById(id);
	}
	/**
	 * @param id
	 * @param invoice
	 * @throws Exception
	 */
	@PutMapping("/{invoiceId}")
	public InvoiceResponseDTO updateById(@PathVariable Integer invoiceId, @RequestBody InvoiceRequestDTO invoiceRequestDTO) throws Exception {
		 return invoiceService.updateById(invoiceId,invoiceRequestDTO);
	}


	/**
	 * @param invoice
	 * @return
	 */
	@PostMapping
	public ResponseEntity<InvoiceResponseDTO> save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {

		InvoiceResponseDTO invoiceResDTO=invoiceService.save(invoiceRequestDTO);

		return ResponseEntity.ok(invoiceResDTO);
}
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public InvoiceResponseDTO get(@PathVariable int id) throws Exception {
		
	return  invoiceService.findById(id);

	}
	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/invoice/{pageNo}")

	public List<Invoice> getInvoiceList(@PathVariable("pageNo")int pageNo, Integer pageSize){
		pageSize=5;

		 List<Invoice> invoice = invoiceService.getInvoiceList(pageNo-1,pageSize);
		return invoice;

	}
	
	@PostMapping("/pagingfilteringandsorting")
	public Page<Invoice> pagingFilteringAndSortingInvoicesByItemCode(@RequestBody CustomRequestDTO customRequestDTO){
	

	

		
		return  invoiceService.pagingFilteringAndSortingInvoicesByItemCode(customRequestDTO);
																
		
	
				
	}
	@PostMapping("/customerDetails")
	public InvoiceResponseDTO getInvoiceDetails(@RequestBody InvoiceDateSearchDTO invoiceDateSearchDTO) throws ParseException {
		
		return  invoiceService.getInvoiceDetails(invoiceDateSearchDTO);
	}
	@GetMapping("/custid/{custId}")
	public ResponseEntity <InvoiceResponseDTO> findByCustId(@PathVariable Integer custId) {
		InvoiceResponseDTO invoicesDTO = invoiceService.findByCustId(custId);
	
		return ResponseEntity.ok(invoicesDTO);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
}
