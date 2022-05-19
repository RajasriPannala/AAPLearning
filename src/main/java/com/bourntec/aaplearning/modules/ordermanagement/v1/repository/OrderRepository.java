package com.bourntec.aaplearning.modules.ordermanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.OrderData;

/**
 * @author Karthika J
 *
 */
@Repository

public interface OrderRepository extends JpaRepository<OrderData, Integer>, JpaSpecificationExecutor<OrderData> {

	

	/**
	 * @param orderId : orderId
	 * @param orderStatus : orderStatus
	 * @return
	 */
	OrderData findByOrderIdAndOrderStatus(Integer orderId, String orderStatus);

	

	
	

	
	

	
}
