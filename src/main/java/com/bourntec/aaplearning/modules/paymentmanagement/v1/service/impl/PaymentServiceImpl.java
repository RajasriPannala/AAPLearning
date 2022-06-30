package com.bourntec.aaplearning.modules.paymentmanagement.v1.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.controller.PaymentController;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.repository.PaymentRepository;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.search.GenericSpecification;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.search.SearchCriteria;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.search.SearchOperations;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.service.PaymentService;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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

	Logger logger =LoggerFactory.getLogger(PaymentController.class);
	@Override
	public List<Payment> findAll() {

		return paymentRepository.findAll();

	}

	@Override
	@CacheEvict(cacheNames = "payments", key = "#id")
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
	@Cacheable(cacheNames = "payments", key = "#id")
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
	@CachePut(cacheNames = "payments", key = "#payment.id")
	public PaymentResponseDTO updateById(Integer id, PaymentRequestDTO paymentRequestDTO) throws Exception {

		PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
		Optional<Payment> paymentOptional = paymentRepository.findById(id);
		if (paymentOptional.isPresent()) {
			Payment foundPayment = paymentOptional.orElseThrow(() -> null);


			paymentRequestDTO.setPaymentId(id);
			// BeanUtils.copyProperties(
			// paymentRequestDTO,foundPayment,getNullPropertyNames(paymentRequestDTO));
			// foundPayment.get();
			Payment payment = paymentRequestDTO.convertToModel(foundPayment);
			foundPayment.setPaymentId(id);
			// foundPayment.setPaymentId(paymentRequestDTO.getPaymentId()!=null?paymentRequestDTO.getPaymentId(),this.);

			Payment payments = paymentRequestDTO.convertToModel();
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

	@Override
	public List<Payment> search(SearchCriteria searchRequest) {

		return paymentRepository.findAll(new GenericSpecification<Payment>(searchRequest));

	}

	@Override
	public List<Payment> searchmultiple(PaymentRequestDTO paymentRequestDTO) {

		GenericSpecification<Payment> genericspecification = new GenericSpecification<Payment>();
		// Payment payment=new Payment();

		if (paymentRequestDTO.getPaidAmount() != null) {
			genericspecification.add(new SearchCriteria("paidAmount", paymentRequestDTO.getPaidAmount(),
					SearchOperations.GREATER_THAN_EQUAL));

		}
		if (paymentRequestDTO.getPaidAmount() != null) {
			genericspecification
					.add(new SearchCriteria("paidAmount", paymentRequestDTO.getPaidAmount(), SearchOperations.EQUAL));

		}
		/*
		 * if(paymentRequestDTO.getStatus() !=null) { genericspecification.add(new
		 * SearchCriteria(
		 * "status",paymentRequestDTO.getStatus(),SearchOperations.EQUAL));
		 * 
		 * }
		 */

		if (paymentRequestDTO.getPaymentId() != null) {
			genericspecification
					.add(new SearchCriteria("paymentId", paymentRequestDTO.getPaymentId(), SearchOperations.EQUAL));

		}
		if (paymentRequestDTO.getPaymentType() != null) {
			genericspecification
					.add(new SearchCriteria("paymentType", paymentRequestDTO.getPaymentType(), SearchOperations.EQUAL));

		}

		return paymentRepository.findAll(genericspecification);

	}

	@Override
	public String generatePdf() throws JRException, IOException {
		
		
		
	
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(paymentRepository.findAll());
		JasperReport compileReport=JasperCompileManager.compileReport(new FileInputStream("src/main/resources/PaymentDetails.jrxml"));
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint report  =  JasperFillManager.fillReport(compileReport, map,beanCollectionDataSource);
		JasperExportManager.exportReportToPdfFile(report,"paymentdetails.pdf");

		logger.info("payment details pdf generated");
		return "generated";
	
	}

	
}
