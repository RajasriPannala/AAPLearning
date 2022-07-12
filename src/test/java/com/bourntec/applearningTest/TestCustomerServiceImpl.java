package com.bourntec.applearningTest;



import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bourntec.aaplearning.entity.Customer;
import com.bourntec.aaplearning.modules.customermanagement.v1.repository.CustomerRepository;
import com.bourntec.aaplearning.modules.customermanagement.v1.service.impl.CustomerServiceImpl;



@ExtendWith(MockitoExtension.class)
public class TestCustomerServiceImpl {


	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Mock
	CustomerRepository customerRepository;



	@Test
	public void saveCustomerTest() {

		Customer customer=Customer.builder()
				//.customerId(2)
				.customerName("user101")
				.address("pathanamthitta")
				.pinCode(689101)
				.phoneNumber((long) 983456782)
				.email("user101@gmail.com")
				.password("user101@123")
				.status("Success")
				.recordStatus("Active")
				.build();

		customerRepository.save(customer);
		Assertions.assertThat(customer).isNotNull();
		Assertions.assertThat(customer.getCustId());
	}

	@Test
	public void findAllCustomerTest(){
		// given - precondition or setup
		// when -  action or the behaviour that we are going test
		List<Customer> customerList = customerRepository.findAll();

		// then - verify the output
		Assertions.assertThat(customerList).isNotNull();
		Assertions.assertThat(customerList.size()).isEqualTo(0);

	}

	@Test
	public void findByIdCustomerTest(){
		// given - precondition or setup
		// when -  action or the behaviour that we are going test
		Optional<Customer> customerList = customerRepository.findById(1);


		// then - verify the output
		Assertions.assertThat(customerList).isNotNull();

	}
	@Test
	public void updateCustomerTest(){
		// given - precondition or setup
		// when -  action or the behaviour that we are going test
		Customer     customer = Customer.builder()
				.customerName("user1")
				.address("pathanamthitta")
				.pinCode(689101)
				.phoneNumber((long) 983456782)
				.email("user1@gmail.com")
				.password("user1@123")
				.status("Success")
				.recordStatus("Active")
				.build();
		// when - action or the behaviour that we are going test
		Customer saveCustomer = customerRepository.save(customer);

		Optional<Customer> Optional = customerRepository.findById(customer.getCustId());



		customer.setStatus("Fail");


		// then - verify the output

		Assertions.assertThat(customer.getStatus()).isEqualTo("Fail");

	}
	@Test
	public void deleteCustomerTest(){


		Customer     customer = Customer.builder()
				.customerName("user1")
				.address("pathanamthitta")
				.pinCode(689101)
				.phoneNumber((long) 983456782)
				.email("user1@gmail.com")
				.password("user1@123")
				.status("Success")
				.recordStatus("Active")
				.build();
		// when - action or the behaviour that we are going test
		Customer saveCustomer = customerRepository.save(customer);


		// when -  action or the behaviour that we are going test
		customerRepository.deleteById(customer.getCustId());
		Optional<Customer> Optional = customerRepository.findById(customer.getCustId());

		// then - verify the output
		Assertions.assertThat(Optional).isEmpty();
	}

}







