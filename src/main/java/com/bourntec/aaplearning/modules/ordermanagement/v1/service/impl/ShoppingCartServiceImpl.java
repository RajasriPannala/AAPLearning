package com.bourntec.aaplearning.modules.ordermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.ShoppingCart;
import com.bourntec.aaplearning.modules.ordermanagement.v1.controller.ShoppingCartController;
import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.ShoppingCartRepository;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.ShoppingCartRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.ShoppingCartResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.ShoppingCartService;


/**
 * @author Aryalekshmi
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired

	ShoppingCartRepository shoppingCartRepository;

	Logger logger =LoggerFactory.getLogger(ShoppingCartController.class);
	
	/**
	 * @author Aryalekshmi
	 * This API is used for delete cart object
	 * @param integer id
	 * @return ShoppingCartResponseDTO
	 *
	 */
	@Override
	public ShoppingCartResponseDTO deleteById(Integer id) {
		ShoppingCartResponseDTO resposeDto = new ShoppingCartResponseDTO();
		try {
			if(shoppingCartRepository.existsById(id)==true) {
				shoppingCartRepository.deleteById(id);
				resposeDto.setResponseMessage("successfully deleted");
				resposeDto.setStatus("Sucess");
			}else {
				resposeDto.setResponseMessage("Data not present");
				resposeDto.setStatus("Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposeDto;
	}
	
	
	/**
	 * @author Aryalekshmi
	 * This API is used for update ShoppingCart object
	 * @param integer id,ShoppingCartRequestDTO shoppingCartRequestDTO
	 * @return ShoppingCartResponseDTO
	 *
	 */
	@Override
	public ShoppingCartResponseDTO updateById(Integer id, ShoppingCartRequestDTO shoppingCartRequestDTO) {
		ShoppingCartResponseDTO shoppingCartResponseDTO = new ShoppingCartResponseDTO(); 
		try {
			
			Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(id);
			if (cartOptional.isPresent()) { 
				ShoppingCart shoppingCart = shoppingCartRequestDTO.convertToModel();
				shoppingCart.setId(id);
				shoppingCart = shoppingCartRepository.save(shoppingCart);
				shoppingCartResponseDTO.setPayload(shoppingCart); 
				shoppingCartResponseDTO.setResponseMessage("ShoppingCart data save sucessfully");
				shoppingCartResponseDTO.setStatus("Sucess"); 
			} else { 
				shoppingCartResponseDTO.setResponseMessage("Coud not fetch data");
				shoppingCartResponseDTO.setStatus("Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shoppingCartResponseDTO;
	}


	/**
	 * @author Aryalekshmi
	 * This API is used for save ShoppingCart object
	 * @param ShoppingCartRequestDTO shoppingCartRequestDTO
	 * @return ShoppingCartResponseDTO
	 *
	 */
	@Override
	public ShoppingCartResponseDTO save(ShoppingCartRequestDTO shoppingCartRequestDTO) {
		ShoppingCartResponseDTO shoppingCartResponseDTO = new ShoppingCartResponseDTO();
		try {
			ShoppingCart shoppingCart = shoppingCartRequestDTO.convertToModel();
			shoppingCart = shoppingCartRepository.save(shoppingCart);
			shoppingCartResponseDTO.setPayload(shoppingCart);
			shoppingCartResponseDTO.setResponseMessage("ShoppingCart data save sucessfully");
			shoppingCartResponseDTO.setStatus("Sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shoppingCartResponseDTO;
	}

	/**
	 * @author Aryalekshmi
	 * This API is used for find ShoppingCart object by id
	 * @param integer id
	 * @return ShoppingCartResponseDTO
	 *
	 */
	@Override
	public ShoppingCartResponseDTO findById(Integer id) {
		ShoppingCartResponseDTO shoppingCartResponseDTO = new ShoppingCartResponseDTO();
		try {
			Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);
			if (shoppingCart != null) {
				shoppingCartResponseDTO.setPayload(shoppingCart.get());
				shoppingCartResponseDTO.setResponseMessage("Data is present");
				shoppingCartResponseDTO.setStatus("Sucess");
			} else {
				shoppingCartResponseDTO.setResponseMessage("Data not found");
				shoppingCartResponseDTO.setStatus("Failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shoppingCartResponseDTO;
	}
	
	@Override
	public List<ShoppingCart> findAll() {
		return shoppingCartRepository.findAll();
	}
}
