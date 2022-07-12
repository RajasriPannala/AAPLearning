package com.bourntec.aaplearning.modules.invoicemanagement.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Karthika J
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomInvoiceItemResponseDTO {

	String responsemessage;
	Object payload;

	String Status;

}
