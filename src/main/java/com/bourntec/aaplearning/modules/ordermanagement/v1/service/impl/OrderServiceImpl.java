package com.bourntec.aaplearning.modules.ordermanagement.v1.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Order;
import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.OrderRepository;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.OrderService;
import com.bourntec.aaplearning.modules.ordermanagement.v1.util.Constants;


/**
 * @author Karthika J
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired

	OrderRepository orderRepository;


	
	/**
	 *
	 */
	@Override
	public OrderResponseDTO findByOrderId(Integer orderId) {

		
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
//		OrderRequestDTO orderRequestDTO=new OrderRequestDTO();
		Order order = orderRepository.findByOrderIdAndOrderStatus(orderId, Constants.OPEN);
		if (order != null) {

			orderResponseDTO.setPaylod(order);
			orderResponseDTO.setResponseMessage("Data found");
			orderResponseDTO.setStatus("Sucess");

//			return orderResponseDTO;
		} else {
			orderResponseDTO.setResponseMessage("Data not found");
			orderResponseDTO.setStatus("Failure");

		}
		return orderResponseDTO;
	}

	
	/**
	 *
	 */
	@Override
	public OrderResponseDTO deleteById(Integer id) {
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

		if (orderRepository.existsById(id) == true) {
			orderRepository.deleteById(id);
			orderResponseDTO.setResponseMessage("Deleted successfully");

			orderResponseDTO.setStatus("Sucess");
			return orderResponseDTO;

		} else

			orderResponseDTO.setResponseMessage("Data not found");
		orderResponseDTO.setStatus("Failure");
		return orderResponseDTO;

	}

	/**
	 *
	 */
	@Override
	public OrderResponseDTO save(OrderRequestDTO orderRequestDTO) {

		OrderResponseDTO ordersDTO = new OrderResponseDTO();
		Order order = orderRequestDTO.convertToModel();
		order.setOrderStatus(Constants.OPEN);
		order = orderRepository.save(order);
		ordersDTO.setPaylod(order);
		ordersDTO.setResponseMessage("order data save sucessfully");
		ordersDTO.setStatus("Sucess");
		return ordersDTO;
	}

	/**
	 *
	 */
	@Override
	public OrderResponseDTO updateById(Integer id, OrderRequestDTO orderRequestDTO) {
		OrderResponseDTO ordersDTO = new OrderResponseDTO();

		Optional<Order> orderOptional = orderRepository.findById(id);
		if (orderOptional.isPresent()) {

			Order order = orderRequestDTO.convertToModel();
			order.setOrderId(id);
			order = orderRepository.save(order);
			ordersDTO.setPaylod(order);

			ordersDTO.setResponseMessage("Fetched data successfully");
			ordersDTO.setStatus("Sucess");

			return ordersDTO;

		} else {

			ordersDTO.setResponseMessage("Coud not fetch data");
			ordersDTO.setStatus("Failed");
			return ordersDTO;
		}

	}

}
