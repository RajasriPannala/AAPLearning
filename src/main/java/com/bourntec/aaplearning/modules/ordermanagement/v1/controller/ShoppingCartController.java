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

import com.bourntec.aaplearning.entity.ShoppingCart;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.ShoppingCartRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.ShoppingCartResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.ShoppingCartService;



/**
 * @author Aryalekshmi
 *
 */

@RestController
@RequestMapping("/shoppingcart")

public class ShoppingCartController {
	
	@Autowired
	
	ShoppingCartService shoppingcartService;

	
	
	
	@GetMapping()
	public List<ShoppingCart> findAll() {

		return shoppingcartService.findAll();

	}
	/**
	 * @param id:shoppingcart id
	 * @return :responsedto
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ShoppingCartResponseDTO> findByCartId(@PathVariable Integer id) {
		ShoppingCartResponseDTO shoppingcartDTO = shoppingcartService.findById(id);
		
		return ResponseEntity.ok(shoppingcartDTO);
	}

	/**
	 * @param id :order id
	 * response:response message
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ShoppingCartResponseDTO> deleteById(@PathVariable Integer id) {
		
		ShoppingCartResponseDTO shoppingcartDTO = shoppingcartService.deleteById(id);
		return ResponseEntity.ok(shoppingcartDTO);
		
	}

	
	/**
	 * @param id ::order id
	 * @param shoppingcartRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ShoppingCartResponseDTO> updateById(@PathVariable Integer id, @RequestBody ShoppingCartRequestDTO shoppingcartRequestDTO) throws Exception {
		
		ShoppingCartResponseDTO shoppingcartDTO = shoppingcartService.updateById(id,shoppingcartRequestDTO);
		
		return ResponseEntity.ok(shoppingcartDTO);

	}

	
	/**
	 * @param :shoppingcartRequestDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<ShoppingCartResponseDTO> save(@RequestBody ShoppingCartRequestDTO shoppingcartRequestDTO) {

		ShoppingCartResponseDTO shoppingcartDTO=shoppingcartService.save(shoppingcartRequestDTO);

		return ResponseEntity.ok(shoppingcartDTO);
	}

}

