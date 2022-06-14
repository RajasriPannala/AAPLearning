package com.bourntec.aaplearning.modules.ordermanagement.v1.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.OrderData;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.OrderService;
import com.bourntec.aaplearning.modules.ordermanagement.v1.util.Constants;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



/**
 * @author Karthika J
 *
 */

@RestController
@RequestMapping("/orders")

public class OrderController {
	
	@Autowired
	
	OrderService orderService;

	
	
	
	@GetMapping()
	public List<OrderData> findAll() {

		return orderService.findAll();

	}
	/**
	 * @param id:order id
	 * @return :responsedto
	 */
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> findByOrderId(@PathVariable Integer id) {
		OrderResponseDTO ordersDTO = orderService.findByOrderId(id);
		
		return ResponseEntity.ok(ordersDTO);
	}

	/**
	 * @param id :order id
	 * response:response message
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> deleteById(@PathVariable Integer id) {
		
		OrderResponseDTO ordersDTO = orderService.deleteById(id);
		return ResponseEntity.ok(ordersDTO);
		
	}

	
	/**
	 * @param id ::order id
	 * @param orderRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> updateById(@PathVariable Integer id, @RequestBody OrderRequestDTO orderRequestDTO) throws Exception {
		
	OrderResponseDTO ordersDTO=	orderService.updateById(id,orderRequestDTO);
		
		return ResponseEntity.ok(ordersDTO);

	}

	
	/**
	 * @param :orderRequestDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<OrderResponseDTO> save(@RequestBody OrderRequestDTO orderRequestDTO) {

		OrderResponseDTO ordersDTO=orderService.save(orderRequestDTO);

		return ResponseEntity.ok(ordersDTO);
		}

	
//	@GetMapping("/pdf")
//	public JRBeanCollectionDataSource generatePdf() {
//		
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(orderService.findAll());
//		return beanCollectionDataSource;
//		
//	}
	@GetMapping("/pdf")
	public String generatePdf()throws JRException, IOException{
		
		orderService.generatePdf();
		return "generated";
		
		


}	
	
	

}
