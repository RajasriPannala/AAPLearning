package com.bourntec.aaplearning.modules.paymentmanagement.v1.service;

import java.util.List;

import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;

public interface PaymentService {

	List<Payment> findAll();

	PaymentResponseDTO updateById(Integer id, PaymentRequestDTO paymentRequestDTO) throws Exception;

	PaymentResponseDTO save(PaymentRequestDTO paymentRequestDTO);

	PaymentResponseDTO deleteById(int id);

	PaymentResponseDTO findByPaymentId(Integer id);

}
