package com.bourntec.aaplearning.modules.invoicemanagement.v1.service;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceCustomRequestDto;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceCustomResponseDto;
/**
 * @author Jeena Thomas
 *
 */
@Service
public interface InvoiceCustomService {

	InvoiceCustomResponseDto save(InvoiceCustomRequestDto invoiceCustomRequestDto);

//	List<InvoiceCustomResponseDto> save(List<InvoiceCustomRequestDto> invoiceCustomRequestDto);

	
}
