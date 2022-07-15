package com.bourntec.aaplearning.modules.invoicemanagement.v1.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceItemRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.CustomInvoiceItemRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.CustomInvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.CustomInvoiceItemService;
import com.bourntec.aaplearning.modules.ordermanagement.v1.controller.OrderController;

/**
 * @author Karthika J
 *
 */

@Service
public class CustomInvoiceItemServiceImpl implements CustomInvoiceItemService {

	@Autowired

	InvoiceItemRepository invoiceItemRepository;

	@Autowired

	InvoiceRepository invoiceRepository;

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	private Integer invoiceId;

	/**
	 * Save inovice data & invoice list on single function
	 * 
	 * @param customInvoiceItemRequestDTO
	 * @return
	 */

	@Override
	public CustomInvoiceItemResponseDTO save(CustomInvoiceItemRequestDTO customInvoiceItemRequestDTO) {

		CustomInvoiceItemResponseDTO invResponseDTO = new CustomInvoiceItemResponseDTO();

		Invoice invoice = customInvoiceItemRequestDTO.converToModel();

		Integer total = 0;

		/**
		 ** filter and null check**
		 * customInvoiceItemRequestDTO.getInvoiceItemList().stream().filter((invitem)
		 * ->invitem.getQuantity()>0);
		 */

		for (InvoiceItem invoiceItem : customInvoiceItemRequestDTO.getInvoiceItemList()) {
			if (invoiceItem.getPrice() > 0 && invoiceItem.getPrice() != null && invoiceItem.getQuantity() != null) {
				total += invoiceItem.getPrice() * invoiceItem.getQuantity();

			}
		}

		/**
		 * total price and set to invoice amount
		 */
		invoice.setInvAmnt(total);

		invoice = invoiceRepository.save(invoice);
		List<InvoiceItem> invoiceItemList = customInvoiceItemRequestDTO.getInvoiceItemList();

		if (!invoiceItemList.isEmpty()) {
			for (InvoiceItem invItemDTO : customInvoiceItemRequestDTO.getInvoiceItemList()) {
				InvoiceItem invoiceItem = new InvoiceItem();
				invItemDTO.setInvoice(invoice);
				invoiceItem = invoiceItemRepository.save(invItemDTO);

			}
		}
		invResponseDTO.setPayload(customInvoiceItemRequestDTO);
		invResponseDTO.setResponsemessage("order data saved sucessfully");

		logger.info("order saved");

		return invResponseDTO;
	}
}
