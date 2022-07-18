package com.bourntec.aaplearning.modules.ordermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bourntec.aaplearning.entity.OrderLine;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.CustomOrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.OrderLineRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.OrderLineResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.OrderLineService;



/**
 * @author Rohini P M
 *
 */
@RestController
@RequestMapping("/orderLine")
public class OrderLineController {

	
@Autowired
	
	OrderLineService orderLineService;





/**
 * @param id:Orderline id
 * @return:responsedto
 */
@GetMapping("/{id}")
public ResponseEntity<OrderLineResponseDTO> findByOrderLineId(@PathVariable Integer id) {
	OrderLineResponseDTO orderLineresDTO = orderLineService.findByOrderLineId(id);
	
	return ResponseEntity.ok(orderLineresDTO);
}



/**
 * @param id:id
 * 
 */
@DeleteMapping("/{id}")
public ResponseEntity<OrderLineResponseDTO> deleteById(@PathVariable Integer id) {
	
	OrderLineResponseDTO orderlineresDTO = orderLineService.deleteById(id);
	return ResponseEntity.ok(orderlineresDTO);
	
}
/**
 * @param id:id
 * @param orderLineRequestDTO
 * @return
 * @throws Exception
 */
@PutMapping("/{id}")
public ResponseEntity<OrderLineResponseDTO> updateById(@PathVariable Integer id, @RequestBody OrderLineRequestDTO orderLineRequestDTO) throws Exception {
	
OrderLineResponseDTO orderlineresDTO=	orderLineService.updateById(id,orderLineRequestDTO);
	
	return ResponseEntity.ok(orderlineresDTO);

}

//@PostMapping
//public ResponseEntity<OrderLineResponseDTO> save(@RequestBody OrderLineRequestDTO orderLineRequestDTO) {
//
//	OrderLineResponseDTO orderlineresDTO=orderLineService.save(orderLineRequestDTO);
//
//	return ResponseEntity.ok(orderlineresDTO);
//	}

/**
 * @param orderLineList
 * @return
 */
@PostMapping
public List<OrderLineResponseDTO> createAll(@RequestBody List<OrderLineRequestDTO> orderLineList) {
return orderLineService.saveAll(orderLineList);
}

/**
 * @return
 */
@GetMapping
public List<OrderLine> findAll() {
	
	return orderLineService.findAll();
}



}




















