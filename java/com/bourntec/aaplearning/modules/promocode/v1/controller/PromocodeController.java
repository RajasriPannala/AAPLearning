package com.bourntec.aaplearning.modules.promocode.v1.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.Promocode;
import com.bourntec.aaplearning.modules.promocode.v1.request.PromocodeRequestDTO;
import com.bourntec.aaplearning.modules.promocode.v1.response.PromocodeResponseDTO;
import com.bourntec.aaplearning.modules.promocode.v1.service.PromocodeService;

@RestController
@RequestMapping("/promocode")  
public class PromocodeController {
	@Autowired
	PromocodeService promocodeService;
	
	@PostMapping
	public ResponseEntity<PromocodeResponseDTO> save(@RequestBody PromocodeRequestDTO promocodeRequestDTO) 
	{
		
		PromocodeResponseDTO promocodeResponseDTO= promocodeService.save(promocodeRequestDTO);
		return ResponseEntity.ok(promocodeResponseDTO);
	}
	@GetMapping("/promocode")
	public PromocodeResponseDTO findByPromoCode(Integer promoCode) {
		PromocodeResponseDTO promoDTO = promocodeService.findByPromoCode(promoCode);
		return promoDTO;
	}
//	@GetMapping("/promocodeanddate")
//	public List<Promocode> findByPromoCodeAndExpiryDate(Integer promoCode, Instant expiryDate) {
//		List<Promocode> promoDTO = promocodeService.findByPromoCodeAndExpiryDate(promoCode,expiryDate);
//		
//		return promoDTO;
//	}
	@PostMapping("/promocodeandtotalamount")
	public PromocodeResponseDTO findByPromoCodeAndTotalAmount( @RequestBody PromocodeRequestDTO promocodeRequestDTO) {
		PromocodeResponseDTO promoDTO = promocodeService.findByPromoCodeAndTotalAmount(promocodeRequestDTO);
		
		return promoDTO;
	}
//	@PostMapping("/promocodeandtotalamount")
//	public List<Promocode> findByPromoCodeAndTotalAmount( @RequestBody PromocodeRequestDTO promocodeRequestDTO) {
//		List<Promocode> promoDTO = promocodeService.findByPromoCodeAndTotalAmount(promocodeRequestDTO);
//		
//		return promoDTO;
//	}

}
