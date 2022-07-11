package com.bourntec.aaplearning.modules.paymentmanagement.v1.service;

import java.io.IOException;
import java.util.List;

import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.entity.PaymentCustomerDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.search.SearchCriteria;

import net.sf.jasperreports.engine.JRException;

/**
 * @author Sandra Diraj
 *
 */

public interface PaymentService {
	
	/**
	 * @param to fetch all details
	 *
	 */
	List<Payment> findAll();

	/**
	 * @param id
	 *update the details using id
	 */

	PaymentResponseDTO updateById(Integer id, PaymentRequestDTO paymentRequestDTO) throws Exception;
	/**
	 * @param id
	 *update the details using id
	 */

	PaymentResponseDTO save(PaymentRequestDTO paymentRequestDTO);
	/**
	 * @param id
	 *deletion using id
	 */

	PaymentResponseDTO deleteById(int id);
	/**
	 * @param id
	 *find using id
	 */

	PaymentResponseDTO findByPaymentId(Integer id);
	/**
	 *
	 *search using a single condition
	 */

	List<Payment> search(SearchCriteria searchRequest);
	/**
	 * search on multiple conditions
	 *
	 */

	List<Payment> searchmultiple(PaymentRequestDTO paymentRequestDTO);
	/**
	 * pdf generation
	 *
	 */
	
	String generatePdf() throws JRException, IOException;
	/**
	 * pdf generation using jasper
	 *
	 */

	String generatePdf2() throws JRException, IOException;
	/**
	 *method for fetching details from multiple tables using native Query
	 *
	 */
	
	List<PaymentCustomerDTO> findAllDetails();
	
	
	//public double findTaxByPaymentType(PaymentType  type);
	
	//String generatePdf2() throws JRException, IOException;


}
