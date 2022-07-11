package com.bourntec.aaplearning.modules.paymentmanagement.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.entity.PaymentCustomerDTO;


/**
 * @author Sandra Diraj
 *
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>,JpaSpecificationExecutor<Payment> {

	/**
	 * to fetch details using id 
	 *
	 */
	Payment findByPaymentIdAndStatus(Integer id, String status);
	/**
	 * joined 2 tables using native query
	 *
	 */
	
	@Query(value="select p.payment_id as paymentId,p.customer_id as customerId,p.paid_amount as paidAmount,c.name as name,c.address as address from payment p join aapcustomer c on p.customer_id=c.customer_id where p.customer_id=1",nativeQuery=true)
	
	List<PaymentCustomerDTO> findAllDetails();
	
	// double findTaxByPaymentType(PaymentType  type);
	

	
	

	

}
