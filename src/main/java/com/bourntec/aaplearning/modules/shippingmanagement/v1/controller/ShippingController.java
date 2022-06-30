package com.bourntec.aaplearning.modules.shippingmanagement.v1.controller;

import java.io.IOException;
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

import com.bourntec.aaplearning.entity.Shipping;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.request.ShippingRequestDTO;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.response.ShippingResponseDTO;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.repository.ShippingRepository;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.service.ShippingService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

	@Autowired
	ShippingService shippingService;

	@GetMapping("/test")
	public String test () {
		return "Hello";
	}
	@GetMapping("/users")
	public String test1 () {
		return "welcome";
}
	@GetMapping("/admins")
	public String test2 () {
		return "Hi";
	}
	

	
	@GetMapping
	public List<Shipping>getAll(){
	return shippingService.findAll();
		}
	
	
	@PutMapping("/{shippingId}")
	public ShippingResponseDTO updateById(@PathVariable int shippingId,
			@RequestBody ShippingRequestDTO shippingRequestDTO) throws Exception {

		return shippingService.updateById(shippingId, shippingRequestDTO);
	}

	@GetMapping("/{shippingId}")
	public ShippingResponseDTO findById(@PathVariable("shippingId") int shippingId) throws Exception {
		return shippingService.findById(shippingId);
	}

	@PostMapping
	public ResponseEntity<ShippingResponseDTO> save(@RequestBody ShippingRequestDTO shippingRequestDTO) throws Exception{

		ShippingResponseDTO shippingResponseDTO = shippingService.save(shippingRequestDTO);
		return ResponseEntity.ok(shippingResponseDTO);
	}

	@DeleteMapping("/{shippingId}")
	public ShippingResponseDTO deleteById(@PathVariable("shippingId") int shippingId) {
		return shippingService.deleteById(shippingId);

	}
	
	@GetMapping("/pdf")
	public String generatePdf()throws JRException, IOException{
		
		shippingService.generatePdf();
		return "generated";
	
	
	}	
}
