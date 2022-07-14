package com.bourntec.aaplearning.modules.ordermanagement.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.ShoppingCart;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.ShoppingCartRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.ShoppingCartResponseDTO;



/**
 * @author Aryalekshmi
 *
 */
@Service
public interface ShoppingCartService {
	
	
	ShoppingCartResponseDTO deleteById(Integer id);
	
	ShoppingCartResponseDTO save(ShoppingCartRequestDTO shoppingcartRequestDTO);

	ShoppingCartResponseDTO findById(Integer cartId);

	ShoppingCartResponseDTO updateById(Integer id, ShoppingCartRequestDTO shoppingcartRequestDTO);

	List<ShoppingCart> findAll();

}






