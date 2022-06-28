package com.bourntec.aaplearning.modules.ordermanagement.v1.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.modules.ordermanagement.v1.controller.OrderController;
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


	
	Logger logger =LoggerFactory.getLogger(OrderController.class);
	
	/**
	 * find order by id
	 * @param id:order id
	 * @return :responsedto
	 */

	@Override
	public OrderResponseDTO findByOrderId(Integer orderId) {

		
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
//		OrderRequestDTO orderRequestDTO=new OrderRequestDTO();
		OrderData order = orderRepository.findByOrderIdAndOrderStatus(orderId, Constants.OPEN);
		if (order != null) {

			orderResponseDTO.setPaylod(order);
			orderResponseDTO.setResponseMessage("Data found");
			orderResponseDTO.setStatus("Sucess");
			logger.info("order found with id number :{}",orderId);

//			return orderResponseDTO;
		} else {
			orderResponseDTO.setResponseMessage("Data not found");
			orderResponseDTO.setStatus("Failure");
			logger.info(" No order found with id number :{}",orderId);
		}
		return orderResponseDTO;
	}

	/**
	 *Delete order by id
	 * @param id:order id
	 * @return :responsedto
	 */
	@Override
	public OrderResponseDTO deleteById(Integer id) {
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

		if (orderRepository.existsById(id) == true) {
			orderRepository.deleteById(id);
			orderResponseDTO.setResponseMessage("Deleted successfully");
			

			orderResponseDTO.setStatus("Sucess");
			logger.info("order deleted by id number :{}",id);
			return orderResponseDTO;

		} else

			orderResponseDTO.setResponseMessage("Data not found");
		orderResponseDTO.setStatus("Failure");
		logger.info("order deletion failured");
		return orderResponseDTO;

	}

	/**
	 *save order by id 
	 * @param orderRequestDTO
	 * @return
	 */
	
	@Override
	public OrderResponseDTO save(OrderRequestDTO orderRequestDTO) {

		OrderResponseDTO ordersDTO = new OrderResponseDTO();
		OrderData order = orderRequestDTO.convertToModel();
		order.setOrderStatus(Constants.OPEN);
		order = orderRepository.save(order);
		ordersDTO.setPaylod(order);
		ordersDTO.setResponseMessage("order data saved sucessfully");
		ordersDTO.setStatus("Sucess");
		logger.info("order saved");
		
		return ordersDTO;
	}

	/**
	 * update order by id
	 * @param id ::order id
	 * @param orderRequestDTO
	 * @return
	 * @throws Exception
	 */
	@Override
	public OrderResponseDTO updateById(Integer id, OrderRequestDTO orderRequestDTO) {
		OrderResponseDTO ordersDTO = new OrderResponseDTO();

		Optional<OrderData> orderOptional = orderRepository.findById(id);
		if (orderOptional.isPresent()) {

			OrderData order = orderRequestDTO.convertToModel();
			order.setOrderId(id);
			order = orderRepository.save(order);
			ordersDTO.setPaylod(order);

			ordersDTO.setResponseMessage("Fetched data successfully");
			ordersDTO.setStatus("Sucess");
			
			logger.info("order updated");

			return ordersDTO;

		} else {

			ordersDTO.setResponseMessage("Coud not fetch data");
			ordersDTO.setStatus("Failed");
			return ordersDTO;
		}

	}

	@Override
	public List<OrderData> findAllOrdersByDateAndcustomerName(LocalDate orderDate, String customerName) {
		// TODO Auto-generated method stub
		return orderRepository.findAllOrdersByDateAndcustomerName(orderDate, customerName);
	}
	@Override
	public List<OrderData> findBycustomerNameandOrdersBetween(String customerName,LocalDate startDate,LocalDate endDate) {
//return orderRepository.findBycustomerNameandOrdersBetween(customerName);
	return orderRepository.findBycustomerNameandOrdersBetween(customerName);
}
	
}
