package com.bourntec.aaplearning.modules.invoicemanagement.v1.service;

import java.util.List;

import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDto;


/**
 * @author Jeena Thomas
 *
 */
public interface InvoiceItemService {
	InvoiceItemResponseDto save(InvoiceItemRequestDto invoiceRequestDTO);

	List<InvoiceItem> findAll();

	InvoiceItemResponseDto deleteById(int id);

	InvoiceItemResponseDto updateById(Integer invoiceId, InvoiceItemRequestDto invoiceItemRequestDTO);

	InvoiceItemResponseDto findById(int id);

	//List<InvoiceItem> findAll();

}
