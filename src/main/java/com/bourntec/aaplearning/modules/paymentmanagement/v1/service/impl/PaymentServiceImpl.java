package com.bourntec.aaplearning.modules.paymentmanagement.v1.service.impl;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Inventory;
import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.InventoryResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceService;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.util.Constants;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.repository.PaymentRepository;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.service.PaymentService;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

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

//       get the invoice object

		final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapperfinal MyPojo pojo =
														// mapper.convertValue(map, MyPojo.class);

		/**
		 * update invoice database
		 */
		
		
		InvoiceResponseDTO impResponse = restTemplate
				.getForObject("http://localhost:8085/invoice/" + payment.getInvoiceId(), InvoiceResponseDTO.class);
//		  Invoice invoice =  (Invoice) impResponse.getInvpayload();

		Invoice invoice = mapper.convertValue(impResponse.getPayload(), Invoice.class);

//		BeanUtils.copyProperties(impResponse.getPayload(), invoice);



//       update the invoice object

//       invoice =  restTemplate.exchange("http://localhost:8082/invoice/"+payment.getInvoiceId(), HttpMethod.GET,invoice , Invoice.class);      

		invoice.setPaidAmnt(payment.getPaidAmount());

		HttpEntity<Invoice> requestEntity = new HttpEntity<>(invoice);
		HttpEntity<InvoiceResponseDTO> response = restTemplate.exchange(
				"http://localhost:8085/invoice/" + invoice.getInvoiceId(), HttpMethod.PUT, requestEntity,
				InvoiceResponseDTO.class);

		
		/**
		 * update order data base
		 */
		
		
		OrderData orderData = restTemplate.getForObject("http://localhost:8081/orders/" + invoice.getOrderId(),
				OrderData.class);

		orderData.setOrderStatus(Constants.CONFIRMED);

		HttpEntity<OrderData> requestEntity1 = new HttpEntity<>(orderData);
		HttpEntity<OrderResponseDTO> response1 = restTemplate.exchange(
				"http://localhost:8081/orders/" + payment.getInvoiceId(), HttpMethod.PUT, requestEntity,
				OrderResponseDTO.class);
		

		
		/**
		 * update inventory table
		 */

		Inventory inventory = restTemplate.getForObject("http://localhost:8084/inventory/" + invoice.getOrderId(),
				Inventory.class);
	
		inventory.setItemCount(inventory.getItemCount() - orderData.getItemcount());

		HttpEntity<Inventory> requestEntity2 = new HttpEntity<>(inventory);
		HttpEntity<InventoryResponseDTO> response2 = restTemplate.exchange(
				"http://localhost:8084/inventory/" + payment.getInvoiceId(), HttpMethod.PUT, requestEntity,
				InventoryResponseDTO.class);
		

		
		
		

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
