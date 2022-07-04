package com.bourntec.aaplearning.modules.ordermanagement.v1.service;



import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.util.Constants;

import net.sf.jasperreports.engine.JRException;






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






	List<OrderData> findAllOrderData(@Param("customer_id") int customer_id);



	
	List<OrderData> findAll();


	String generatePdf() throws JRException, IOException;
	
//	public static List<OrderData>generateOrderList(){
//		return Arrays.asList(
//		new OrderData(122, 3, 54884,6666,"aaa",3,LocalDate.parse("1999-10-26"),1212,Constants.OPEN),
//		new OrderData(123, 4, 54885,6667,"bbb",4,LocalDate.parse("2000-10-26"),1213,Constants.OPEN),
//		new OrderData(124, 5, 54886,6668,"ccc",3,LocalDate.parse("1997-01-06"),1212,Constants.OPEN));
//		
//		
//		
//				
//	}			
		
		
	}







