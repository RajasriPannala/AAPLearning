 package com.bourntec.aaplearning.modules.customermanagement.v1.repository;

import java.util.Optional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Customer;
import com.bourntec.aaplearning.modules.customermanagement.v1.request.CustomerRequestDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;


/**
 * @author Sarath G Krishnan
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
	
	/**
	 * @param customerRequestDTO
	 * @return
	 * save customer details
	 */
	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);

	/**
	 * @param customerId
	 * @param active
	 * find customer using customer id and record status
	 * @return
	 */
	Customer findByCustomerIdAndRecordStatus(Integer customerId, String active);

	Optional<Customer> findById(Integer customerId);

	}
