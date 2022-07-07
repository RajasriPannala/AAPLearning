package com.bourntec.aaplearning.modules.ordermanagement.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.OrderLine;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.CustomOrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderLineResponseDTO;

//@Service
public interface OrderLineService {
	
	List<OrderLine> findAll();

	OrderLineResponseDTO deleteById(Integer id);
	

//	OrderLineResponseDTO save(OrderLineRequestDTO orderLineRequestDTO);



	OrderLineResponseDTO findByOrderLineId(Integer orderLineId);


	OrderLineResponseDTO updateById(Integer id, OrderLineRequestDTO orderLineRequestDTO);

	List<OrderLineResponseDTO> saveAll(List<OrderLineRequestDTO> orderLineList);

	



}
