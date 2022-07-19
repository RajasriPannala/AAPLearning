package com.bourntec.aaplearning.modules.paymentmanagement.v1.service;

import org.springframework.stereotype.Service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;



@Service
public interface PayPalService {

	Payment createPayment(double price, String currency, String method, String intent, String description,
			String cancelUrl, String successUrl) throws PayPalRESTException;

	Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;

}
