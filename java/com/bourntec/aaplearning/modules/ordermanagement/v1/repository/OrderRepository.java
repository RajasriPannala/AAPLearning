package com.bourntec.aaplearning.modules.ordermanagement.v1.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	@Query(value="select * from order_data where order_date='2022-09-02' and customer_name='jeena'", nativeQuery = true)
	List<OrderData> findAllOrdersByDateAndcustomerName(LocalDate orderDate, String customerName);
	

	
	@Query(value="select orders.* from order_data as orders left JOIN  aapcustomer as cust on (orders.cust_id = cust.cust_id) where  cust.customer_name= :customerName and orders.order_date BETWEEN '2022-09-01' AND '2022-09-05'", nativeQuery = true)
	//@Query(value="select * from order_data  where  customer_name=?1", nativeQuery = true)
	List<OrderData> findBycustomerNameandOrdersBetween(String customerName);
	

}
