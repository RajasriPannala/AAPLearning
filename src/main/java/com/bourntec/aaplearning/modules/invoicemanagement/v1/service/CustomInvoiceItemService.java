/**
 * 
 */
package com.bourntec.aaplearning.modules.invoicemanagement.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.entity.OrderLine;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.CustomInvoiceItemRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.CustomInvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.CustomOrderLineResponseDTO;

/**
 * @author Karthika J
 *
 */

@Service


/**
 * @param customInvoiceItemRequestDTO
 * @return
 */
public interface CustomInvoiceItemService {
	
	CustomInvoiceItemResponseDTO save(CustomInvoiceItemRequestDTO customInvoiceItemRequestDTO);

	
	
	
}
