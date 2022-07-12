package com.bourntec.aaplearning.modules.promocode.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.Promocode;
import com.bourntec.aaplearning.modules.promocode.v1.request.PromocodeRequestDTO;
import com.bourntec.aaplearning.modules.promocode.v1.response.PromocodeResponseDTO;
import com.bourntec.aaplearning.modules.promocode.v1.service.PromocodeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Jeena Thomas
 *
 */
@RestController
@RequestMapping("/promocode")  
@SecurityRequirement(name = "promocodeapi")
@CrossOrigin("*")
public class PromocodeController {
	@Autowired
	PromocodeService promocodeService;
	
	@PostMapping
	@Operation(description = "save method",
    summary="Methods to save all details of promocode ")
   @ApiResponse(responseCode = "200",
   content=@Content(schema=@Schema(implementation = Promocode.class)),description = "Data fetched!!!")
	public ResponseEntity<PromocodeResponseDTO> save(@RequestBody PromocodeRequestDTO promocodeRequestDTO) 
	{
		
		PromocodeResponseDTO promocodeResponseDTO= promocodeService.save(promocodeRequestDTO);
		return ResponseEntity.ok(promocodeResponseDTO);
	}
	
	@GetMapping("/promocode")
	@Operation(description = "find By method",
    summary="Methods to get all details of promocode ")
   @ApiResponse(responseCode = "200",
   content=@Content(schema=@Schema(implementation = Promocode.class)),description = "Data fetched!!!")
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
	@Operation(description = "find By method",
    summary="Methods to get all details of promocode ")
   @ApiResponse(responseCode = "200",
   content=@Content(schema=@Schema(implementation = Promocode.class)),description = "Data fetched!!!")
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
