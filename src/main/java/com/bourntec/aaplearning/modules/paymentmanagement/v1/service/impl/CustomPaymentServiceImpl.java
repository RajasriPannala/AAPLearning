/**
 * 
 */
package com.bourntec.aaplearning.modules.paymentmanagement.v1.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Inventory;
import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.InventoryResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.controller.OrderController;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.util.Constants;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.repository.PaymentRepository;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.service.CustomPaymentService;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Karthika J
 *
 */

@Primary
@Service
public class CustomPaymentServiceImpl implements CustomPaymentService{
		

	@Autowired
	PaymentRepository paymentRepository;
	

	@Autowired
	RestTemplate restTemplate;

	Logger logger =LoggerFactory.getLogger(OrderController.class);
	
	
	@Override
	public PaymentResponseDTO saveCustomPayment(PaymentRequestDTO paymentRequestDTO) {
		PaymentResponseDTO payresDTO = new PaymentResponseDTO();

		Payment payment = paymentRequestDTO.convertToModel();
		payment.setStatus(Constant.ACTIVE);

		payment = paymentRepository.save(payment);
	
		
		// get the invoice object

		final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapperfinal MyPojo pojo =
		// mapper.convertValue(map, MyPojo.class);

		/**
		* update invoice database and set payment
		*/
		
		
		
		InvoiceResponseDTO invResponse = restTemplate
				
				
		.getForObject("http://localhost:8085/invoice/" + payment.getInvoiceId(), InvoiceResponseDTO.class);
		// Invoice invoice = (Invoice) impResponse.getInvpayload();


		Invoice invoice = mapper.convertValue(invResponse.getPayload(), Invoice.class);


		// BeanUtils.copyProperties(impResponse.getPayload(), invoice);


		// update the invoice object


		// invoice = restTemplate.exchange("http://localhost:8082/invoice/"+payment.getInvoiceId(), HttpMethod.GET,invoice , Invoice.class);

        
		
		invoice.setPaidAmnt(payment.getPaidAmount());

		HttpEntity<Invoice> requestEntity = new HttpEntity<>(invoice);
		HttpEntity<InvoiceResponseDTO> response = restTemplate.exchange(
		"http://localhost:8085/invoice/" + invoice.getInvoiceId(), HttpMethod.PUT, requestEntity,
		InvoiceResponseDTO.class);
		

		/**
		* update order data base and change status to confirmed after payment
		*/
		
		

        if(invoice.getOrderId() != null ) {
        	
		OrderResponseDTO orderResponse = restTemplate.getForObject("http://localhost:8081/orders/" + invoice.getOrderId(),
				OrderResponseDTO.class);
		

		OrderData orderData = mapper.convertValue(orderResponse.getPaylod(), OrderData.class);

       if(orderData!= null ) {
		orderData.setOrderStatus(Constants.CONFIRMED);

		HttpEntity<OrderData> requestEntity1 = new HttpEntity<>(orderData);
		HttpEntity<OrderResponseDTO> response1 = restTemplate.exchange(
		"http://localhost:8081/orders/" + payment.getInvoiceId(), HttpMethod.PUT, requestEntity1,
		OrderResponseDTO.class);
		
       }
		
               
        
		/**
		* update inventory table decrement item count after payment
		*/


		InventoryResponseDTO inventoryResponseDTO = restTemplate.getForObject("http://localhost:8084/inventory/" + orderData.getInventoryId(),
		InventoryResponseDTO.class);
		
		Inventory inventory = mapper.convertValue(inventoryResponseDTO.getPaylod(), Inventory.class);

		inventory.setItemCount(inventory.getItemCount() - orderData.getItemcount());

		HttpEntity<Inventory> requestEntity2 = new HttpEntity<>(inventory);
		HttpEntity<InventoryResponseDTO> response2 = restTemplate.exchange(
		"http://localhost:8084/inventory/" + payment.getInvoiceId(), HttpMethod.PUT, requestEntity2,
		InventoryResponseDTO.class);
		
		

        }else
        	logger.info("id not found");
        	
		
        
		payresDTO.setPayload(payment);
		payresDTO.setResponsemessage("Payment data saved sucessfully");
		payresDTO.setStatus("Sucess");
		return payresDTO;
	}

	
}
