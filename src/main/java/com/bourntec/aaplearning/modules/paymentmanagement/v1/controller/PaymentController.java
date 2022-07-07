package com.bourntec.aaplearning.modules.paymentmanagement.v1.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.Payment;
import com.bourntec.aaplearning.entity.PaymentCustomerDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.request.PaymentRequestDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.response.PaymentResponseDTO;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.search.SearchCriteria;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import net.sf.jasperreports.engine.JRException;

/**
 * @author Sandra Diraj
 *
 */

@RestController
@RequestMapping("v1/paymentmanagement")
@SecurityRequirement(name = "paymentapi")
@CrossOrigin("*")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping()
	@Operation(description = "find All method",
			   summary="Methods to get all user's payment information")
	@ApiResponse(responseCode = "200",
	   content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data feteched!!!") 
	public List<Payment> findAll() {
		return paymentService.findAll();

	}

	/**
	 * @Request ResponseDTO Save method for Payment Managemnet Entity
	 *
	 */

	@PostMapping
	@Operation( summary= "Save method",
			description ="To save all details",
	   responses= {@ApiResponse(responseCode = "200",
	   content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data Fetched sucessfully"),
			   @ApiResponse(responseCode="400",description = "Invalid request"),
			   @ApiResponse(responseCode = "500",description = "Server Error")},
		parameters= {@Parameter(name="save method", description = "Save the details",example = "sana",in = ParameterIn.PATH)}
	)
	public ResponseEntity<PaymentResponseDTO> save(@RequestBody PaymentRequestDTO paymentReqDTO) {

		PaymentResponseDTO payresDTO = paymentService.save(paymentReqDTO);

		return ResponseEntity.ok(payresDTO);
	}

	/**
	 *
	 * update using payment id for Payment Managemnet Entity
	 *
	 */
	@PutMapping("/{id}")
	@Operation( summary= "Update Method",
			description="To update all details",
	   responses= {@ApiResponse(responseCode = "200",
	   content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data Fetched sucessfully"),
			   @ApiResponse(responseCode="400",description = "Invalid request"),
			   @ApiResponse(responseCode = "500",description = "Server Error")},
		parameters= {@Parameter(name="update", description = "update using id",example = "21",in = ParameterIn.PATH)}
	)
	public ResponseEntity<PaymentResponseDTO> updateById(@PathVariable int id, @RequestBody PaymentRequestDTO paymentRequestDTO) throws Exception {

		PaymentResponseDTO paymentResDTO = paymentService.updateById(id, paymentRequestDTO);

		return ResponseEntity.ok(paymentResDTO);

	}

	/**
	 * @Request Param id-Payment id Save method for Payment Management Entity
	 *
	 */

	@DeleteMapping("/{id}") // void
	@Operation(summary = "Delete method",
			description ="To delete unwanted details",
	   responses= {@ApiResponse(responseCode = "200",
	   content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data Fetched sucessfully"),
			   @ApiResponse(responseCode="400",description = "Invalid request"),
			   @ApiResponse(responseCode = "500",description = "Server Error")},
		parameters= {@Parameter(name="deleteById", description = "Delete using id",example = "21",in = ParameterIn.PATH)}
	)
	public PaymentResponseDTO deleteById(@PathVariable int id) {
		return paymentService.deleteById(id);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Find by id method",
				description ="To details of a particular payment using id",
				responses= {@ApiResponse(responseCode = "200",
				content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data Fetched sucessfully"),
						@ApiResponse(responseCode="400",description = "Invalid request"),
						@ApiResponse(responseCode = "500",description = "Server Error")},	
				parameters= {@Parameter(name="findById", description = "provide any id",example = "21")
					
})
	public PaymentResponseDTO findByPaymentId(@PathVariable Integer id) {
		return paymentService.findByPaymentId(id);
	}
	/**
	 * @Request Search using generic specification,based on a single criteria.
	 *
	 */
	
	@PostMapping("/search/dynamic")
	@Operation(summary = "Dynamic Search",
	description ="To search using single details  ",
	responses= {@ApiResponse(responseCode = "200",
	content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data Fetched sucessfully"),
			@ApiResponse(responseCode="400",description = "Invalid request"),
			@ApiResponse(responseCode = "500",description = "Server Error")
})
	public List<Payment>search(@RequestBody SearchCriteria searchRequest)
	{
	return paymentService.search(searchRequest);
	}
	/**
	 * @Request Dynamic search on multiple criteria.
	 *
	 */
	@PostMapping("/dynamic")
	@Operation(summary = "Dynamic Search",
	description ="To search using multiple details  ",
	responses= {@ApiResponse(responseCode = "200",
	content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data Fetched sucessfully"),
			@ApiResponse(responseCode="400",description = "Invalid request"),
			@ApiResponse(responseCode = "500",description = "Server Error")
})
	public List<Payment> searchmultiple(@RequestBody PaymentRequestDTO searchRequest)
	{
	return paymentService.searchmultiple(searchRequest);
	}

	@GetMapping("/pdf")
	@Operation(summary = "Generate pdf",
	description ="Details are downloaded using pdf",
	responses= {@ApiResponse(responseCode = "200",
	content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data Fetched sucessfully"),
			@ApiResponse(responseCode="400",description = "Invalid request"),
			@ApiResponse(responseCode = "500",description = "Server Error")

})
	public String generatePdf()throws JRException, IOException{
		
		paymentService.generatePdf();
		return "generated";
	

}
	@GetMapping("/pdf1")
	@Operation(summary = "Generate pdf",
	description ="Details are downloaded using pdf",
	responses= {@ApiResponse(responseCode = "200",
	content=@Content(schema=@Schema(implementation = Payment.class)),description = "Data Fetched sucessfully"),
			@ApiResponse(responseCode="400",description = "Invalid request"),
			@ApiResponse(responseCode = "500",description = "Server Error")
})
	public String generatePdf2()throws JRException, IOException{
		
		paymentService.generatePdf2();
		return "generated";
}
	@GetMapping("/findall")
	public List<PaymentCustomerDTO> findAllDetails() {
		return paymentService.findAllDetails();
	}
}
