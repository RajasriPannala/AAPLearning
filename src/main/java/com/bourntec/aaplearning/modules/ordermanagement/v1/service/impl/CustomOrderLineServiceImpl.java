package com.bourntec.aaplearning.modules.ordermanagement.v1.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.entity.OrderLine;
import com.bourntec.aaplearning.modules.ordermanagement.v1.controller.OrderController;
import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.OrderLineRepository;
import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.OrderRepository;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.CustomOrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.CustomOrderLineResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.CustomOrderLineService;



@Service
public class CustomOrderLineServiceImpl implements CustomOrderLineService{

//	
	@Autowired

	OrderLineRepository orderLineRepository;
	
	@Autowired

	OrderRepository orderRepository;
	
	Logger logger =LoggerFactory.getLogger(OrderController.class);
	
	
//	@Override
	public CustomOrderLineResponseDTO save(CustomOrderLineRequestDTO customOrderLineRequestDTO) {
		CustomOrderLineResponseDTO ordersDTO = new CustomOrderLineResponseDTO();
		
		OrderData order = customOrderLineRequestDTO.converToModel();
//		order.setOrderStatus(Constants.OPEN);
		order = orderRepository.save(order);
		List<OrderLine> OrderLineList=customOrderLineRequestDTO.getOrderList();
		OrderLine orderLine=null;
//		CustomOrderLineRequestDTO customOrderLineRequestDTO=new CustomOrderLineRequestDTO();
//		List<CustomOrderLineRequestDTO> customOrderLineRequestDTOList=new ArrayList<>();
		if (!OrderLineList.isEmpty()) {
		for(OrderLine orderLineDTO:customOrderLineRequestDTO.getOrderList())
		{
			orderLineDTO.setOrderData(order);
			orderLine = orderLineRepository.save(orderLineDTO);
		}}
		ordersDTO.setPaylod(customOrderLineRequestDTO);
		ordersDTO.setResponseMessage("order data saved sucessfully");
//		ordersDTO.setStatus("Sucess");
		logger.info("order saved");
		
		return ordersDTO;
	}
	
	
		
}
	





	
//	
	
	



	

