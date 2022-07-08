package com.bourntec.aaplearning.modules.ordermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.OrderData;

@Repository

public interface CustomOrderLineRepository extends JpaRepository<OrderData,Integer>,JpaSpecificationExecutor<OrderData>{

	
	OrderData findByOrderId(Integer orderId);
	
	OrderData save(OrderData orderData);
	
	

}
