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



/**
 * @author Rohini P M
 *
 */
@Service
public class CustomOrderLineServiceImpl implements CustomOrderLineService{

	
	@Autowired

	OrderLineRepository orderLineRepository;
	
	@Autowired

	OrderRepository orderRepository;
	
	Logger logger =LoggerFactory.getLogger(OrderController.class);

	private Integer orderId;
	
	
	
//	@Override
	public CustomOrderLineResponseDTO save(CustomOrderLineRequestDTO customOrderLineRequestDTO) {
		CustomOrderLineResponseDTO ordersDTO = new CustomOrderLineResponseDTO();
		
		
		OrderData orderData = customOrderLineRequestDTO.converToModel();


		Integer	total = 0;
		Integer totalCount=0;
		

		for(OrderLine orderLine:customOrderLineRequestDTO.getOrderList() ) {
		if (orderLine.getItemprice() > 0 && orderLine.getItemprice() != null){
			total +=  orderLine.getItemprice() * orderLine.getItemQuantity() ;
			totalCount += orderLine.getItemQuantity();
			
			
		}}
		orderData.setItemcount(totalCount);
		orderData.setTotalPrice(total);
			
		orderData = orderRepository.save(orderData);
		List<OrderLine> OrderLineList=customOrderLineRequestDTO.getOrderList();


		if (!OrderLineList.isEmpty()) {
		for(OrderLine orderLineDTO:customOrderLineRequestDTO.getOrderList())
		{
			OrderLine orderLine = new OrderLine();
			orderLineDTO.setOrderData(orderData);
			orderLine = orderLineRepository.save(orderLineDTO);

		}}
		ordersDTO.setPaylod(customOrderLineRequestDTO);
		ordersDTO.setResponseMessage("order data saved sucessfully");

		logger.info("order saved");
		
		return ordersDTO;


	}}
	
	
		

	





	
//	
	
	



	

