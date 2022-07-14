package com.bourntec.aaplearning.modules.invoicemanagement.v1.service;
import java.util.List;

import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDTO;
/**
 * @author Aryalekshmi
 *
 */
public interface InvoiceItemService 
	{
	 	List<InvoiceItem> findAll();
	 	InvoiceItemResponseDTO  deleteById(int id);
	 	InvoiceItemResponseDTO updateById(Integer id ,InvoiceItemRequestDTO invoiceitemReqDTO);
	 	InvoiceItemResponseDTO save(InvoiceItemRequestDTO invoiceitem);
	 	InvoiceItemResponseDTO findById(int id) throws Exception;
	 	List<InvoiceItem> getInvoiceItemList(int i, Integer j);
	}
