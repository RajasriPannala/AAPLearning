package com.bourntec.aaplearning.modules.ordermanagement.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Wishlist;
import com.bourntec.aaplearning.modules.ordermanagement.v1.request.WishlistRequestDTO;
import com.bourntec.aaplearning.modules.ordermanagement.v1.response.WishlistResponseDTO;






/**
 * @author Aryalekshmi
 */
@Service
public interface WishlistService {
	
	
	/**
	 * @author Aryalekshmi
	 * This API is used for delete Wishlist object
	 * @param integer id
	 * @return WishlistResponseDTO
	 *
	 */
	WishlistResponseDTO deleteById(Integer id);
	
	
	/**
	 * @author Aryalekshmi
	 * This API is used for update wishlist object
	 * @param integer id,WishlistRequestDTO wishlistRequestDTO
	 * @return WishlistResponseDTO
	 *
	 */
	WishlistResponseDTO updateById(Integer id, WishlistRequestDTO wishlistRequestDTO);

	/**
	 * @author Aryalekshmi
	 * This API is used for save wishlist object
	 * @param WishlistRequestDTO wishlistRequestDTO
	 * @return WishlistResponseDTO
	 *
	 */
	WishlistResponseDTO save(WishlistRequestDTO wishlistRequestDTO);

	/**
	 * @author Aryalekshmi
	 * This API is used for find Wishlist object by id
	 * @param integer id
	 * @return WishlistResponseDTO
	 *
	 */
	WishlistResponseDTO findById(Integer id);
	
	List<Wishlist> findAll();
}






