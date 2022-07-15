
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

import com.bourntec.aaplearning.entity.Wishlist;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.WishlistRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.WishlistResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.WishlistService;



/**
 * @author Aryalekshmi
 *
 */

@RestController
@RequestMapping("/wishlist")

public class WishlistController {
	
	@Autowired
	
	WishlistService wishlistService;

	
	
	
	@GetMapping()
	public List<Wishlist> findAll() {

		return wishlistService.findAll();

	}
	/**
	 * @param id:wishlist id
	 * @return :responsedto
	 */
	@GetMapping("/{id}")
	public ResponseEntity<WishlistResponseDTO> findByOrderId(@PathVariable Integer id) {
		WishlistResponseDTO wishlistDTO = wishlistService.findById(id);
		
		return ResponseEntity.ok(wishlistDTO);
	}

	/**
	 * @param id :order id
	 * response:response message
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<WishlistResponseDTO> deleteById(@PathVariable Integer id) {
		
		WishlistResponseDTO wishlistDTO = wishlistService.deleteById(id);
		return ResponseEntity.ok(wishlistDTO);
		
	}

	
	/**
	 * @param id ::order id
	 * @param wishlistRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<WishlistResponseDTO> updateById(@PathVariable Integer id, @RequestBody WishlistRequestDTO wishlistRequestDTO) throws Exception {
		
	WishlistResponseDTO shoppingcartDTO = wishlistService.updateById(id,wishlistRequestDTO);
		
		return ResponseEntity.ok(shoppingcartDTO);

	}

	
	/**
	 * @param :shoppingcartRequestDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<WishlistResponseDTO> save(@RequestBody WishlistRequestDTO wishlistRequestDTO) {

		WishlistResponseDTO shoppingcartDTO=wishlistService.save(wishlistRequestDTO);

		return ResponseEntity.ok(shoppingcartDTO);
		}

}


