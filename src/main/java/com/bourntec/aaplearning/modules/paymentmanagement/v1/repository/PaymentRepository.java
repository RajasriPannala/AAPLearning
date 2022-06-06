package com.bourntec.aaplearning.modules.paymentmanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>,JpaSpecificationExecutor<Payment> {

	Payment findByPaymentIdAndStatus(Integer id, String status);

	
	

	

}
