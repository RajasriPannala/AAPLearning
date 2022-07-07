package com.bourntec.aaplearning.modules.ordermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.entity.OrderLine;
import com.bourntec.aaplearning.modules.ordermanagement.v1.controller.OrderController;
import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.OrderLineRepository;
import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.OrderRepository;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.CustomOrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.CustomOrderLineResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderLineResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.OrderLineService;



@Primary
@Service
public class OrderLineServiceImpl implements OrderLineService{

	
	@Autowired

	OrderLineRepository orderLineRepository;
	
	@Autowired

	OrderRepository orderRepository;
	
	
	Logger logger =LoggerFactory.getLogger(OrderController.class);


	@Override
	public List<OrderLine> findAll() {

		return orderLineRepository.findAll();
	}


	@Override
	public OrderLineResponseDTO deleteById(Integer id) {
		
			OrderLineResponseDTO orderLineResponseDTO = new OrderLineResponseDTO();

			if (orderLineRepository.existsById(id) == true) {
				orderLineRepository.deleteById(id);
				orderLineResponseDTO.setResponseMessage("Deleted successfully");
				

//				orderLineResponseDTO.setStatus("Sucess");
				logger.info("order deleted by id number :{}",id);
				return orderLineResponseDTO;

			} else

				orderLineResponseDTO.setResponseMessage("Data not found");
//			orderLineResponseDTO.setStatus("Failure");
			logger.info("order deletion failured");
			return orderLineResponseDTO;

		
		
	}


//	@Override
//	public OrderLineResponseDTO save(OrderLineRequestDTO orderLineRequestDTO) {
//		OrderLineResponseDTO ordersDTO = new OrderLineResponseDTO();
//		try {
//		
//		
//		OrderLine orderLine = orderLineRequestDTO.converToModel();
////		orderLine.setOrderLineStatus(Constants.OPEN);
//		OrderData order = orderRepository.findByOrderId(orderLineRequestDTO.getOrderId());
//		orderLine.setOrderData(order);
////		orderLineRequestDTO.getORDERID();
//		orderLine = orderLineRepository.save(orderLine);
//		ordersDTO.setPaylod(orderLine);
//		ordersDTO.setResponseMessage("order data saved sucessfully");
////		ordersDTO.setStatus("Sucess");
//		logger.info("order saved");
//		}
//		catch(Exception e) {
//			e.getMessage();
//		}
//		
//		return ordersDTO;
//	}


	@Override
	public List <OrderLineResponseDTO> saveAll(List<OrderLineRequestDTO> orderLineRequestDTOList) {
//	OrderLineResponseDTO ordersDTO = new OrderLineResponseDTO();
	// List<OrderLineResponseDTO> orderRes=new ArrayList<>();
	List<OrderLine> orderLineList=new ArrayList<>();
	OrderLine orderLine=null;
	OrderLineRequestDTO orderLineRequestDTO=new OrderLineRequestDTO();
	OrderData order = orderRepository.findByOrderId(orderLineRequestDTO.getOrderId());
	
	for(OrderLineRequestDTO orderLineDTO:orderLineRequestDTOList )
	{
		
//		OrderData order = orderRepository.findByOrderId(orderLineDTO.getOrderId());
	orderLine=orderLineDTO.converToModel();

	orderLine.setOrderData(order);

	orderLineList.add(orderLine);
//	ordersDTO.setPaylod(orderLine);
//	ordersDTO.setResponseMessage("order data saved sucessfully");


	}

	// orderLineRepository.saveAll(orderLineList).stream().
	// map(OrderLineResponseDTO::new).toList());


	List<OrderLineResponseDTO> res= orderLineRepository.saveAll(orderLineList).stream().
	map(OrderLineResponseDTO::new).toList();
//	ordersDTO.setPaylod(res);
	return res;

	}






	@Override
	public OrderLineResponseDTO findByOrderLineId(Integer orderLineId) {

		OrderLineResponseDTO orderLineResponseDTO = new OrderLineResponseDTO();
//		OrderRequestDTO orderRequestDTO=new OrderRequestDTO();
		OrderLine orderLine = orderLineRepository.findByOrderLineId(orderLineId );
		if (orderLine != null) {

			orderLineResponseDTO.setPaylod(orderLine);
			orderLineResponseDTO.setResponseMessage("Data found");
//			orderLineResponseDTO.setStatus("Sucess");
			logger.info("order found with id number :{}",orderLineId);

			return orderLineResponseDTO;
		} else {
			orderLineResponseDTO.setResponseMessage("Data not found");
//			orderLineResponseDTO.setStatus("Failure");
			logger.info(" No order found with id number :{}",orderLineId);
		}
		return orderLineResponseDTO;
	}


	@Override
	public OrderLineResponseDTO updateById(Integer id, OrderLineRequestDTO orderLineRequestDTO) {

		OrderLineResponseDTO ordersDTO = new OrderLineResponseDTO();

		Optional<OrderLine> orderLineOptional = orderLineRepository.findById(id);
		if (orderLineOptional.isPresent()) {

			OrderLine orderLine = orderLineRequestDTO.converToModel();
			orderLine.setOrderLineId(id);
			orderLine = orderLineRepository.save(orderLine);
			ordersDTO.setPaylod(orderLine);

			ordersDTO.setResponseMessage("Fetched data successfully");
//			ordersDTO.setStatus("Sucess");
			
			logger.info("order updated");

			return ordersDTO;

		} else {

			ordersDTO.setResponseMessage("Coud not fetch data");
//			ordersDTO.setStatus("Failed");
			return ordersDTO;
		}
	}


	


	


//	
	
	
	
}
