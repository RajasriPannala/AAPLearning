package com.bourntec.aaplearning.modules.merchandisemanagement.v1.controller;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.merchandisemanagement.v1.request.MerchandiseRequestDto;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.response.MerchandiseResponseDto;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.service.MerchandiseService;



/**ss
 * @author Aryalekshmi
 *
 */

@RestController
@RequestMapping("/merchandise")
public class MerchandiseController {
	
	@Autowired
	MerchandiseService merchandiseService;
	
	
	/**
	 * @author Aryalekshmi
	 * This API is used for delete merchandise object
	 * @param integer id
	 * @return MerchandiseResponseDto
	 *
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<MerchandiseResponseDto> deleteById(@PathVariable Integer id) {
		MerchandiseResponseDto responseDto = merchandiseService.deleteById(id);
		return ResponseEntity.ok(responseDto);
	}


	/**
	 * @author Aryalekshmi
	 * This API is used for update merchandise object
	 * @param integer id,MerchandiseRequestDto merchandiseRequestDto
	 * @return MerchandiseResponseDto
	 *
	 */
	@PutMapping("/{id}")
	public ResponseEntity<MerchandiseResponseDto> updateById(@PathVariable Integer id,@RequestBody MerchandiseRequestDto merchandiseRequestDto) throws Exception {
		MerchandiseResponseDto responseDto = merchandiseService.updateById(id,merchandiseRequestDto);
		return ResponseEntity.ok(responseDto);
	}

	

	/**
	 * @author Aryalekshmi
	 * This API is used for save merchandise object
	 * @param MerchandiseRequestDto merchandiseRequestDto
	 * @return MerchandiseResponseDto
	 *
	 */
	@PostMapping()
	
	
	public ResponseEntity<MerchandiseResponseDto> save(@Valid @RequestBody MerchandiseRequestDto merchandiseRequestDto) {
		MerchandiseResponseDto responseDto = merchandiseService.save(merchandiseRequestDto);
		return ResponseEntity.ok(responseDto);
	}
	
	/*
	 * @GetMapping() public ResponseEntity<List<MerchandiseResponseDto>> findAll(){
	 * List<MerchandiseResponseDto> list = merchandiseService.findAll(); return
	 * ResponseEntity.ok(list); }
	 */
	
	/**
	 * @author Aryalekshmi
	 * This API is used for find merchandise object by id
	 * @param integer id
	 * @return MerchandiseResponseDto
	 *
	 */
	@GetMapping("/{id}")
	public ResponseEntity<MerchandiseResponseDto> findById(@PathVariable Integer id){
		MerchandiseResponseDto responseDto = merchandiseService.findById(id);
		return ResponseEntity.ok(responseDto);
	}
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler
		public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
		String fieldName = ((FieldError) error).getField();
		String errorMessage = error.getDefaultMessage();
		errors.put(fieldName, errorMessage);
		});
		return errors;
		}


	
}
