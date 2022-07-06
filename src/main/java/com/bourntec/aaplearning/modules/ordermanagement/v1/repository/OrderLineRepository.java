package com.bourntec.aaplearning.modules.ordermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.OrderLine;



/**
 * @author Rohini P M
 *
 */
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>, JpaSpecificationExecutor<OrderLine> {


//	OrderLine findByOrderIdAndOrderStatus(Integer orderId, String orderStatus);
	
	/**
	 * orderLine details using orderline id
	 * @find orderLine details using orderline id
	 */
	OrderLine findByOrderLineId(Integer orderLineId);
	
}



