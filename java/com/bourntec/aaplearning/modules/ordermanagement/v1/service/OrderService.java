package com.bourntec.aaplearning.modules.ordermanagement.v1.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;





/**
 * @author Karthika J
 *
 */
@Service
public interface OrderService {
	
	
	OrderResponseDTO deleteById(Integer id);
	

	OrderResponseDTO save(OrderRequestDTO orderRequestDTO);



	OrderResponseDTO findByOrderId(Integer orderId);


	OrderResponseDTO updateById(Integer id, OrderRequestDTO orderRequestDTO);


	List<OrderData> findAllOrdersByDateAndcustomerName(LocalDate orderDate, String customerName);


	List<OrderData> findBycustomerNameandOrdersBetween(String customerName, LocalDate startDate, LocalDate endDate);


	





}
