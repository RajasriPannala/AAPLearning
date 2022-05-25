package com.bourntec.aaplearning.modules.paymentmanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.repository.PaymentRepository;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.service.PaymentService;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;

/**
 * @author Sandra Diraj
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	RestTemplate restTemplate;

//	@Autowired
//	InvoiceService invoiceService;

	@Override
	public List<Payment> findAll() {

		return paymentRepository.findAll();

	}
	
	

	@Override
	public PaymentResponseDTO deleteById(int id) {

		PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();

		if (paymentRepository.existsById(id)) {
			paymentRepository.deleteById(id);
			paymentResponseDTO.setResponsemessage("Deleted successfully");
			paymentResponseDTO.setStatus("Sucess");

		} else {
			paymentResponseDTO.setResponsemessage("Data not found");
			paymentResponseDTO.setStatus("Failure");

		}
		return paymentResponseDTO;
	}

	/**
	 * Request Param: Payment DTO
	 */

	
	@Override
	public PaymentResponseDTO save(PaymentRequestDTO paymentRequestDTO) {
		PaymentResponseDTO payresDTO = new PaymentResponseDTO();

		Payment payment = paymentRequestDTO.convertToModel();
		payment.setStatus(Constant.ACTIVE);

		payment = paymentRepository.save(payment);

		
		
		

		payresDTO.setPayload(payment);
		payresDTO.setResponsemessage("Payment data saved sucessfully");
		payresDTO.setStatus("Sucess");
		return payresDTO;
	}

	/**
	 * Request Param:id-Payment id
	 */
	@Override
	public PaymentResponseDTO findByPaymentId(Integer id) {

		PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
		Payment payment = paymentRepository.findByPaymentIdAndStatus(id, Constant.ACTIVE);
		if (payment != null) {

			paymentResponseDTO.setPayload(payment);
			paymentResponseDTO.setResponsemessage("Id is present");
			paymentResponseDTO.setStatus("Sucess");

		} else {

			paymentResponseDTO.setResponsemessage("The person with  id " + id + " is not found ");
			paymentResponseDTO.setStatus("Failure");

		}
		return paymentResponseDTO;
	}

	/**
	 * Request Param:id-Payment id Request Param Payment ResponseDTO
	 */
	public PaymentResponseDTO updateById(Integer id, PaymentRequestDTO paymentRequestDTO) throws Exception {

		PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
		Optional<Payment> paymentOptional = paymentRepository.findById(id);
		if (paymentOptional.isPresent()) {

			Payment payment = paymentRequestDTO.convertToModel();
			payment.setPaymentId(id);
			paymentRepository.save(payment);
			paymentResponseDTO.setPayload(payment);
			paymentResponseDTO.setResponsemessage(" data save sucessfully");
			paymentResponseDTO.setStatus("Sucess");

		} else {

			paymentResponseDTO.setResponsemessage(" id not present");
			paymentResponseDTO.setStatus("failed");

		}
		return paymentResponseDTO;
	}
	/*
	 * Optional<Payment> paymentOptional = paymentRepository.findById(id); if
	 * (paymentOptional.isPresent()) {
	 * 
	 * Payment alreadyExsist = paymentOptional.get(); payment.setPaymentId(id);
	 * 
	 * return paymentRepository.save(payment); } else throw new
	 * Exception("Record does not exist"); }
	 */

}
/*
 * public CustomerResponseDTO updateById(Integer customerId, CustomerRequestDTO
 * customerRequestDTO) { CustomerResponseDTO CustomerResponseDTO = new
 * CustomerResponseDTO(); Optional<Customer> customerOptional =
 * customerRepository.findById(customerId); if (customerOptional.isPresent()) {
 * 
 * 
 * 
 * Customer customer = customerRequestDTO.convertToModel(); Customer
 * existingcustomer = customerOptional.get();
 * 
 * 
 * 
 * customer.setCustomerId(customerId); customerRepository.save(customer);
 * CustomerResponseDTO.setPayLoad(customer);
 * CustomerResponseDTO.setResponseMessage(" data save sucessfully");
 * CustomerResponseDTO.setStatus("Sucess"); return CustomerResponseDTO; } else
 * 
 * 
 * 
 * CustomerResponseDTO.setResponseMessage(" id not present");
 * CustomerResponseDTO.setStatus("failed"); return CustomerResponseDTO;
 * 
 * 
 * 
 * }
 */

/*
 * PaymentResponseDTO paymentResDTO = new PaymentResponseDTO(); Payment payment
 * =paymentRepository.findByPaymentIdAndStatus(id,Constant.ACTIVE); if(payment
 * != null) { //payable=paymentRepository.save(payment);
 * paymentResDTO.setPayload(payment);
 * paymentResDTO.setResponsemessage("Id is present");
 * paymentResDTO.setStatus("Sucess");
 * 
 * } else {
 * 
 * paymentResDTO.setResponsemessage("Data not found");
 * paymentResDTO.setStatus("Failure");
 * 
 * } return payable; }
 */
//public Payment updateById(Integer id, Payment payment) throws Exception {
/*
 * PaymentResponseDTO payresDTO = new PaymentResponseDTO();
 * 
 * Payment payment = paymentRequestDTO.convertToModel();
 * payment.setStatus(Constant.ACTIVE); payment =
 * paymentRepository.findById(payment, id); payresDTO.setPayload(payment);
 * payresDTO.setResponsemessage("Payment data save sucessfully");
 * payresDTO.setStatus("Sucess"); return payresDTO; }
 */
/*
 * public void findById(int id) {
 * 
 * Optional < Payment > optional = paymentRepository.findById(id);
 * 
 * if (optional.isPresent()) { System.out.println(optional.get()); } else {
 * System.out.printf("No employee found with id %d%n", id);
 * 
 * } //return null;} } }
 * 
 * /* Patient patient =
 * patientRepository.findByRecordStatusAndId(Constatnts.ACTIVE, id);
 * 
 * if (patient != null) { patient.setRecordStatus(Constatnts.DELETED);
 * 
 * patientRepository.save(patient); } else { throw new
 * RecordNotFoundException("Not found"); }
 * 
 * }
 */
