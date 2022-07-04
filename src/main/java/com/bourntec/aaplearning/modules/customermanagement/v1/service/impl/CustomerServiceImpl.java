package com.bourntec.aaplearning.modules.customermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Customer;
import com.bourntec.aaplearning.modules.customermanagement.v1.repository.CustomerRepository;
import com.bourntec.aaplearning.modules.customermanagement.v1.request.CustomerRequestDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.response.CustomerResponseDTO;
import com.bourntec.aaplearning.modules.customermanagement.v1.service.CustomerService;
import com.bourntec.aaplearning.modules.customermanagement.v1.util.Constants;

/**
 * @author Sarath G Krishnan
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	CustomerRepository customerRepository;

	/**
	 * find customer using id
	 */
	@Override
	public CustomerResponseDTO findById(int customerId) throws Exception {

		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {

			customerResponseDTO.setPayLoad(customerOptional.get());
			customerResponseDTO.setResponseMessage(" data got sucessfully");
			logger.info("Successfully fetched");
			customerResponseDTO.setStatus("Sucess");
			return customerResponseDTO;
		} else {
			customerResponseDTO.setResponseMessage(" Given id does not exists");
			logger.error("User Not Found");
			customerResponseDTO.setStatus("failed");
			return customerResponseDTO;
		}
	}

	/**
	 * delete customer using customer id
	 */
	@Override

	public CustomerResponseDTO deleteById(Integer customerId) {
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		if (customerRepository.existsById(customerId) == true) {
			customerRepository.deleteById(customerId);
			customerResponseDTO.setResponseMessage("Deleted successfully");
			customerResponseDTO.setStatus("Sucess");
			logger.info("deleted");
			return customerResponseDTO;
		} else
			customerResponseDTO.setResponseMessage("Data not found");
		logger.error("User Not Found");
		return customerResponseDTO;
	}

	/**
	 * save customer details
	 */
	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		CustomerResponseDTO custResDTO = new CustomerResponseDTO();

		Customer customer = customerRequestDTO.convertToModel();
		customer.setRecordStatus(Constants.ACTIVE);
		customer = customerRepository.save(customer);
		custResDTO.setPayLoad(customer);
		custResDTO.setResponseMessage("Payment data save sucessfully");
		logger.info("data saved successfully");
		custResDTO.setStatus("Sucess");
		return custResDTO;
	}

	/**
	 * update customer details
	 */
	@Override
	public CustomerResponseDTO updateById(Integer customerId, CustomerRequestDTO customerRequestDTO) {
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			Customer foundcustomer = customerOptional.orElseThrow(() -> null);
			customerRequestDTO.setCustomerId(customerId);
			Customer customer = customerRequestDTO.convertToModel(foundcustomer);
			foundcustomer.setCustomerId(customerId);
			Customer customers = customerRequestDTO.convertToModel();
			customer.setCustomerId(customerId);
			customerRepository.save(customer);

			customerResponseDTO.setPayLoad(customers);
			customerResponseDTO.setResponseMessage("Data Updated Successfully");
			customerResponseDTO.setStatus("Sucess");
		} else {
			customerResponseDTO.setResponseMessage(" id not present");
			customerResponseDTO.setStatus("failed");
		}
		return customerResponseDTO;
	}
	


	@Override
	public List<Customer> CustomerFilter() throws Exception {
		List<Customer> customer = new ArrayList<>();
		customer = customerRepository.findAll();
		return customer.stream().filter(c -> "vayanad".equals(c.getAddress())).collect(Collectors.toList());
	}

	/**
	 *
	 */
	@Override
	public String findPincode(int id) {
		String pincodeRange = null;
		Optional<Customer> Optional = customerRepository.findById(id);
		if (Optional.isPresent()) {
			int pincode = Optional.get().getPinCode();

			if (pincode == 123456)
				pincodeRange = "thiruvalla";
			else if (pincode == 689101)
				pincodeRange = "pathanmthitta";
			else if (pincode == 689115)
				pincodeRange = "thirumoolapuram";
			else if (pincode == 689106)
				pincodeRange = "thengeli";
			else
				pincodeRange = "not found";

		}
		return pincodeRange;

	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();

	}

}
