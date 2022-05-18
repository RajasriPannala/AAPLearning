package com.bourntec.aaplearning.modules.ordermanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Order;

/**
 * @author Karthika J
 *
 */
@Repository

public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {

	

	/**
	 * @param orderId : orderId
	 * @param orderStatus : orderStatus
	 * @return
	 */
	Order findByOrderIdAndOrderStatus(Integer orderId, String orderStatus);

	

	
	

	
	

	
}
