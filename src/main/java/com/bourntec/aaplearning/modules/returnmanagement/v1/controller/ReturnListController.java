package com.bourntec.aaplearning.modules.returnmanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnListRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnListResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnListService;

/**
 * @author Sarath G Krishnan
 *
 */
@RestController
@RequestMapping("/returnList")
public class ReturnListController {

	@Autowired
	ReturnListService returnListService;

	/**
	 * @param returnListRequestDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<ReturnListResponseDTO> save(@RequestBody ReturnListRequestDTO returnListRequestDTO) {

		ReturnListResponseDTO returnDTO = returnListService.save(returnListRequestDTO);

		return ResponseEntity.ok(returnDTO);

	}
}