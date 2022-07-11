package com.bourntec.aaplearning.modules.customermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
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
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author Sarath G Krishnan
 *
 */
@RestController
@RequestMapping("/customermanagement/v1")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getall")
	public List<Customer> getAll() {

		return  
				customerService.findAll();

	}
	@GetMapping("/filter")
	public List<Customer> CustomerFilter() throws Exception {
		return  customerService.CustomerFilter();
	}

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
	public CustomerResponseDTO findById(@PathVariable int customerId) {
		CustomerResponseDTO customerDTO = null;
		try {
			customerDTO = customerService.findById(customerId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerDTO;
	}
//	/**
//	 * @param customerId
//	 * @return
//	 * @throws Exception
//	 */
//	@GetMapping("filter/{customerId}")
//	public MappingJacksonValue filter1(@PathVariable int customerId) throws Exception {
//		//CustomerRequestDTO customerRequestDTO;
//		CustomerResponseDTO list= customerService.findById(customerId);
//		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("customerId","name","address","pinCode");
//		FilterProvider filters = new SimpleFilterProvider().addFilter("customerDetails", filter);
//		MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(list);
//		mappingJacksonValue.setFilters(filters);
//		return mappingJacksonValue;
//	}

}
