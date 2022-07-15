package com.bourntec.aaplearning.modules.invoicemanagement.v1.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.CustomRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceDateSearchDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;


/**
 * @author Esther Tomy
 *
 */
public interface InvoiceService {
	
	 List<Invoice> findAll();

	 InvoiceResponseDTO  deleteById(int id);
//	 Invoice save(InvoiceResponseDTO invoiceReqDTO);

	

//	Invoice updateById(Integer id , Invoice invoice) throws Exception;
	InvoiceResponseDTO updateById(Integer id ,InvoiceRequestDTO invoiceReqDTO) ;

	InvoiceResponseDTO save(InvoiceRequestDTO invoice);

	InvoiceResponseDTO findById(int id) throws Exception;


	List<Invoice> getInvoiceList(int i, Integer j);

	void downloadAsCsv();

	Page<Invoice> pagingFilteringAndSortingInvoicesByItemCode(CustomRequestDTO customRequestDTO);

	

	InvoiceResponseDTO getInvoiceDetails(InvoiceDateSearchDTO invoiceDateSearchDTO) throws ParseException;



	




	

//	List<InvoiceResponseDTO> findAll();


}
