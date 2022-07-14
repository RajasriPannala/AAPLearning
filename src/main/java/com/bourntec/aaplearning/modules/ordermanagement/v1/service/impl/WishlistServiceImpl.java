package com.bourntec.aaplearning.modules.ordermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Wishlist;
import com.bourntec.aaplearning.modules.ordermanagement.v1.controller.WishlistController;
import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.WishlistRepository;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.WishlistRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.WishlistResponseDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.service.WishlistService;


/**
 * @author Arya
 *
 */
@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired

	WishlistRepository wishlistRepository;

	Logger logger =LoggerFactory.getLogger(WishlistController.class);
	
	/**
	 * @author Aryalekshmi
	 * This API is used for delete Wishlist object
	 * @param integer id
	 * @return WishlistResponseDTO
	 *
	 */
	@Override
	public WishlistResponseDTO deleteById(Integer id) {
		WishlistResponseDTO resposeDto = new WishlistResponseDTO();
		try {
			if(wishlistRepository.existsById(id)==true) {
				wishlistRepository.deleteById(id);
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
	 * This API is used for update wishlist object
	 * @param integer id,WishlistRequestDTO wishlistRequestDTO
	 * @return WishlistResponseDTO
	 *
	 */
	@Override
	public WishlistResponseDTO updateById(Integer id, WishlistRequestDTO wishlistRequestDTO) {
		WishlistResponseDTO wishlistResponseDTO = new WishlistResponseDTO(); 
		try {
			
			Optional<Wishlist> wishlistOptional = wishlistRepository.findById(id);
			if (wishlistOptional.isPresent()) { 
				Wishlist wishlist = wishlistRequestDTO.convertToModel();
				wishlist.setId(id);
				wishlist = wishlistRepository.save(wishlist);
				wishlistResponseDTO.setPayload(wishlist); 
				wishlistResponseDTO.setResponseMessage("Wishlist data save sucessfully");
				wishlistResponseDTO.setStatus("Sucess"); 
			} else { 
				wishlistResponseDTO.setResponseMessage("Coud not fetch data");
				wishlistResponseDTO.setStatus("Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wishlistResponseDTO;
	}


	/**
	 * @author Aryalekshmi
	 * This API is used for save wishlist object
	 * @param WishlistRequestDTO wishlistRequestDTO
	 * @return WishlistResponseDTO
	 *
	 */
	@Override
	public WishlistResponseDTO save(WishlistRequestDTO wishlistRequestDTO) {
		WishlistResponseDTO wishlistResponseDTO = new WishlistResponseDTO();
		try {
			Wishlist wishlist = wishlistRequestDTO.convertToModel();
			wishlist = wishlistRepository.save(wishlist);
			wishlistResponseDTO.setPayload(wishlist);
			wishlistResponseDTO.setResponseMessage("Wishlist data save sucessfully");
			wishlistResponseDTO.setStatus("Sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wishlistResponseDTO;
	}

	/**
	 * @author Aryalekshmi
	 * This API is used for find Wishlist object by id
	 * @param integer id
	 * @return WishlistResponseDTO
	 *
	 */
	@Override
	public WishlistResponseDTO findById(Integer id) {
		WishlistResponseDTO wishlistResponseDTO = new WishlistResponseDTO();
		try {
			Optional<Wishlist> wishlist = wishlistRepository.findById(id);
			if (wishlist != null) {
				wishlistResponseDTO.setPayload(wishlist.get());
				wishlistResponseDTO.setResponseMessage("Data is present");
				wishlistResponseDTO.setStatus("Sucess");
			} else {
				wishlistResponseDTO.setResponseMessage("Data not found");
				wishlistResponseDTO.setStatus("Failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wishlistResponseDTO;
	}
	
	@Override
	public List<Wishlist> findAll() {
		return wishlistRepository.findAll();
	}

	
}
