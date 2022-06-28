package com.bourntec.aaplearning.modules.customermanagement.v1.controller;

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

import com.bourntec.aaplearning.entity.Customer;
import com.bourntec.aaplearning.modules.customermanagement.v1.request.CustomerRequestDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.service.CustomerService;


/**
 * @author Sarath G Krishnan
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	

	/**
	 * @param customerId
	 */
	@DeleteMapping("/{customerId}")
	public CustomerResponseDTO deleteById(@PathVariable int customerId) {
		return customerService.deleteById(customerId);

	}

	/**
	 * @param customerRequestDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<CustomerResponseDTO> save(@RequestBody CustomerRequestDTO customerRequestDTO) {

		CustomerResponseDTO custResDTO = customerService.save(customerRequestDTO);

		return ResponseEntity.ok(custResDTO);
	}

	/**
	 * @param customerId
	 * @param customerRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{customerId}")
	public CustomerResponseDTO updateById(@PathVariable Integer customerId,
			@RequestBody CustomerRequestDTO customerRequestDTO) throws Exception {
		return customerService.updateById(customerId, customerRequestDTO);
	}

	/**
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{customerId}")
	public CustomerResponseDTO findById(@PathVariable int customerId) throws Exception {
		return customerService.findById(customerId);
		}
	
	
	

}
	