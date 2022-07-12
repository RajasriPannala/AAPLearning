package com.bourntec.aaplearning.modules.promocode.v1.service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Promocode;
import com.bourntec.aaplearning.modules.promocode.v1.request.PromocodeRequestDTO;
import com.bourntec.aaplearning.modules.promocode.v1.response.PromocodeResponseDTO;
/**
 * @author Jeena Thomas
 *
 */
@Service
public interface PromocodeService {

	PromocodeResponseDTO save(PromocodeRequestDTO promocodeRequestDTO);


	//List<Promocode> findByPromoCodeAndExpiryDate(Integer promoCode, Instant expiryDate);


	//List<Promocode> findByPromoCodeAndTotalAmount(Integer promoCode, Integer totalAmount);


	PromocodeResponseDTO findByPromoCodeAndTotalAmount(PromocodeRequestDTO promocodeRequestDTO);


	PromocodeResponseDTO findByPromoCode(Integer promoCode);


	//PromocodeResponseDTO findByPromoCode(PromocodeRequestDTO promocodeRequestDTO);


	//Promocode findByPromoCode(Integer promoCode, Instant expiryDate);

}