package com.bourntec.aaplearning.modules.paymentmanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.service.PaymentService;

/**
 * @author Sandra Diraj
 *
 */

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping()
	public List<Payment> findAll() {
		return paymentService.findAll();

	}

	/**
	 * @Request ResponseDTO Save method for Payment Managemnet Entity
	 *
	 */

	@PostMapping
	public ResponseEntity<PaymentResponseDTO> save(@RequestBody PaymentRequestDTO paymentReqDTO) {

		PaymentResponseDTO payresDTO = paymentService.save(paymentReqDTO);

		return ResponseEntity.ok(payresDTO);
	}

	/**
	 *
	 * update using payment id for Payment Managemnet Entity
	 *
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PaymentResponseDTO> updateById(@PathVariable int id,
			@RequestBody PaymentRequestDTO paymentRequestDTO) throws Exception {

		PaymentResponseDTO paymentResDTO = paymentService.updateById(id, paymentRequestDTO);

		return ResponseEntity.ok(paymentResDTO);

	}

	/**
	 * @Request Param id-Payment id Save method for Payment Managemnet Entity
	 *
	 */

	@DeleteMapping("/{id}") // void
	public PaymentResponseDTO deleteById(@PathVariable int id) {
		return paymentService.deleteById(id);
	}

	@GetMapping("/{id}")
	public PaymentResponseDTO findByPaymentId(@PathVariable Integer id) {
		return paymentService.findByPaymentId(id);
	}

}
