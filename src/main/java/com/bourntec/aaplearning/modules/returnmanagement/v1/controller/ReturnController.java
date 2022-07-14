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

import com.bourntec.aaplearning.entity.Return;

import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


/**
 * @author Rohini P M
 *
 */
@RestController
@RequestMapping("/returnmanagement/v1")

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
	@Operation( summary= "save method",
            description ="To save all details",
        responses= {@ApiResponse(responseCode = "200",
        content=@Content(schema=@Schema(implementation = Return.class)),description = "Data Fetched sucessfully"),
               @ApiResponse(responseCode="400",description = "Invalid request"),
               @ApiResponse(responseCode = "500",description = "Server Error")},
        parameters= {@Parameter(name="save method", description = "Save the details",example = "sana",in = ParameterIn.PATH)}
            )
	@PostMapping("")
	public ResponseEntity<ReturnResponseDTO> save(@RequestBody ReturnRequestDTO returnReqDTO) {

	ReturnResponseDTO retresDTO=returnService.save(returnReqDTO);

	return ResponseEntity.ok(retresDTO);
	}

	

	/**
	 * @param id
	 * @return
	 */
	@Operation( summary= "delete method",
            description ="To save all details",
        responses= {@ApiResponse(responseCode = "200",
        content=@Content(schema=@Schema(implementation = Return.class)),description = "Data Fetched sucessfully"),
               @ApiResponse(responseCode="400",description = "Invalid request"),
               @ApiResponse(responseCode = "500",description = "Server Error")},
        parameters= {@Parameter(name="save method", description = "Save the details",example = "sana",in = ParameterIn.PATH)}
            )
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
	@Operation( summary= "update method",
            description ="To save all details",
        responses= {@ApiResponse(responseCode = "200",
        content=@Content(schema=@Schema(implementation = Return.class)),description = "Data Fetched sucessfully"),
               @ApiResponse(responseCode="400",description = "Invalid request"),
               @ApiResponse(responseCode = "500",description = "Server Error")},
        parameters= {@Parameter(name="save method", description = "Save the details",example = "sana",in = ParameterIn.PATH)}
            )
	@PutMapping("/{returnId}")
	public ReturnResponseDTO updateById(@PathVariable Integer returnId, @RequestBody ReturnRequestDTO returnRequestDTO) throws Exception {
		return returnService.updateById(returnId,returnRequestDTO);
		}
	
	
	
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Operation( summary= "find method",
            description ="To save all details",
        responses= {@ApiResponse(responseCode = "200",
        content=@Content(schema=@Schema(implementation = Return.class)),description = "Data Fetched sucessfully"),
               @ApiResponse(responseCode="400",description = "Invalid request"),
               @ApiResponse(responseCode = "500",description = "Server Error")},
        parameters= {@Parameter(name="save method", description = "Save the details",example = "sana",in = ParameterIn.PATH)}
            )
	@GetMapping("/{id}")
	public ReturnResponseDTO get(@PathVariable int id) throws Exception {

	return returnService.findById(id);



	}
}

