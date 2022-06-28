package com.bourntec.aaplearning.modules.returnmanagement.v1.controller;

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

import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnService;


/**
 * @author Rohini P M
 *
 */
@RestController
@RequestMapping("/return")
public class ReturnController {
	
	@Autowired
	ReturnService returnService;

	/**
	 * @return 
	 */
//	@GetMapping
//	public List<Return> findAll() {
//		
//		return returnService.findAll();
//	}

	
	/**
	 * @param returnReqDTO
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<ReturnResponseDTO> save(@RequestBody ReturnRequestDTO returnReqDTO) {

	ReturnResponseDTO retresDTO=returnService.save(returnReqDTO);

	return ResponseEntity.ok(retresDTO);
	}

	

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ReturnResponseDTO deleteById(@PathVariable Integer id) {
		return returnService.deleteById(id);
		
	}
	
	/**
	 * @param returnId
	 * @param returnRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{returnId}")
	public ReturnResponseDTO updateById(@PathVariable Integer returnId, @RequestBody ReturnRequestDTO returnRequestDTO) throws Exception {
		return returnService.updateById(returnId,returnRequestDTO);
		}
	
	
	
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ReturnResponseDTO get(@PathVariable int id) throws Exception {

	return returnService.findById(id);



	}
}
