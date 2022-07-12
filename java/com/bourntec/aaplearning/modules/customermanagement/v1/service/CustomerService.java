package com.bourntec.aaplearning.modules.customermanagement.v1.service;

import com.bourntec.aaplearning.modules.customermanagement.v1.request.CustomerRequestDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;

/**
 * @author Sarath G Krishnan
 *
 */
public interface CustomerService {
	
	/**
	 * @param customerRequestDTO
	 * save customer
	 * @return
	 */
	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);

	/**
	 * @param customer
	 * delete customer using customer id
	 * @return
	 */
	CustomerResponseDTO deleteById(Integer customer);

	/**
	 * @param customerId
	 * @param customerRequestDTO
	 * update customer details using customer id
	 * @return
	 */
	CustomerResponseDTO updateById(Integer custId, CustomerRequestDTO customerRequestDTO);

	/**
	 * @param customerId
	 * @return
	 * find  customer using customer id
	 * @throws Exception
	 */
	CustomerResponseDTO findById(int custId) throws Exception;

	String findPincode(int id);
}
