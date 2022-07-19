package com.bourntec.aaplearning.modules.paymentmanagement.v1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.service.PayPalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

/**
 * @param PayPalController
 * @return
 */
@RestController
public class PayPalController {
	@Autowired
	PayPalService service;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	@GetMapping("/")
	public String Home() {
		return "Home";
	}

	@PostMapping("/pay")
	public String payment(@ModelAttribute("order") OrderRequestDTO orderRequestDTO) throws PayPalRESTException {
		Payment payment = service.createPayment(orderRequestDTO.getPrice(), orderRequestDTO.getCurrency(),
				orderRequestDTO.getMethod(), orderRequestDTO.getIntent(), orderRequestDTO.getDescription(),
				"http://localhost:8080/" + CANCEL_URL, "http://localhost:8080/" + SUCCESS_URL);
		for (Links link : payment.getLinks()) {
				if (link.getRel().equals("approval_url")) {
				return "redirect:" + link.getHref();
			}
		}
		return "redirect:/";
	}

	@GetMapping(value = CANCEL_URL)
	public String cancelPay() {
		return "cancel";
	}

	@GetMapping(value = SUCCESS_URL)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId)
			throws PayPalRESTException {
		Payment payment = service.executePayment(paymentId, payerId);
		System.out.println(payment.toJSON());
		if (payment.getState().equals("approved")) {
			return "success";
		}
		return "redirect:/";
	}

}
