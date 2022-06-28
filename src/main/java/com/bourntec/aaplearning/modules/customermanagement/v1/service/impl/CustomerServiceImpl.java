package com.bourntec.aaplearning.modules.customermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

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
	 *find customer using id 
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
	 *delete customer using customer id
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
	 *save customer details
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
	 *update customer details
	 */
	@Override
	public CustomerResponseDTO updateById(Integer customerId, CustomerRequestDTO customerRequestDTO) {
		CustomerResponseDTO CustomerResponseDTO = new CustomerResponseDTO();
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {

			Customer customer = customerRequestDTO.convertToModel();
			Customer existingcustomer = customerOptional.get();

			customer.setCustomerId(customerId);
			customerRepository.save(customer);
			CustomerResponseDTO.setPayLoad(customer);
			CustomerResponseDTO.setResponseMessage(" data save sucessfully");
			logger.info("data updated");
			CustomerResponseDTO.setStatus("Sucess");
			return CustomerResponseDTO;
		} else

			CustomerResponseDTO.setResponseMessage(" id not present");
		logger.error("User Not Found");
		CustomerResponseDTO.setStatus("failed");
		return CustomerResponseDTO;

	}


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


}
