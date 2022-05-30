/**
 * 
 */
package com.bourntec.aaplearning.modules.paymentmanagement.v1.service;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;

/**
 * @author Karthika J
 *
 */


public interface CustomPaymentService {
	
	PaymentResponseDTO saveCustomPayment(PaymentRequestDTO paymentRequestDTO);

}
