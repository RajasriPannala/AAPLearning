package com.bourntec.aaplearning.modules.ordermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.OrderData;

/**
 * @author Rohini P M
 *
 */
@Repository

public interface CustomOrderLineRepository extends JpaRepository<OrderData,Integer>,JpaSpecificationExecutor<OrderData>{

	
	/**
	 * @param orderId: orderId
	 * @return
	 */
	OrderData findByOrderId(Integer orderId);
	
	
	OrderData save(OrderData orderData);
	
	

}
