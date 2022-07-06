package com.bourntec.aaplearning.modules.ordermanagement.v1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.OrderData;

/**
 * @author Karthika J
 *
 */

@Repository

//@Service
public interface OrderRepository extends JpaRepository<OrderData, Integer>, JpaSpecificationExecutor<OrderData> {

	

	


	


	/**
	 * @param orderId : orderId
	 * @param orderStatus : orderStatus
	 * @return
	 */
	OrderData findByOrderIdAndOrderStatus(Integer orderId, String orderStatus);

	OrderData findByOrderId(Integer orderId);

	
	@Query(value="select order_data.*  from order_data inner join "
			+ "payment on order_data.cust_id = payment.customer_id join aapcustomer"
			+ " on aapcustomer.customer_id = order_data.cust_id where payment.status = 'A' "
			+ "and order_data.order_status = 'C' and aapcustomer.customer_id = payment.customer_id "
			+ "and payment.customer_id = order_data.cust_id and aapcustomer.customer_id = :customer_id",nativeQuery=true)
	List<OrderData> findAllOrderData(@Param("customer_id") int customer_id);

	

	


	
	

	
	

	
}
