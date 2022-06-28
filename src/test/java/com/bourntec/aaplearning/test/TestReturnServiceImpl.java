package com.bourntec.aaplearning.test;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bourntec.aaplearning.entity.Return;
import com.bourntec.aaplearning.modules.returnmanagement.v1.repository.ReturnRepository;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl.ReturnServiceImpl;



@ExtendWith(MockitoExtension.class)
class TestReturnServiceImpl {
	
	@InjectMocks
	ReturnServiceImpl returnServiceImpl;
	@Mock
	ReturnRepository returnRepository;
	@Test
	
	public void saveReturnTest() {

		Return returnManagement=Return.builder().
			itemCount(31).invoiceId(1234).custId(1254).itemCode(365).retAmt(1000)
			.qty(2).description("good").Status("Active").build();

	returnRepository.save(returnManagement);
	Assertions.assertThat(returnManagement).isNotNull();
	Assertions.assertThat(returnManagement.getReturnId());
	}

	
	@Test
	public void findByIdReturnTest(){
	
	Optional<Return> returnList = returnRepository.findById(1);

	Assertions.assertThat(returnList).isNotNull();

	}
	
	
	@Test
	public void updateReturnTest(){
	
	Return returnManagement = Return.builder().itemCount(31).invoiceId(1234).custId(1254).itemCode(365).retAmt(1000)
			.qty(2).description("good").Status("A").build();
	
	
//	Return saveReturn = returnRepository.save(returnManagement); 
//	Optional<Return> Optional = returnRepository.findById(returnManagement.getReturnId()); 
	Assertions.assertThat(returnManagement.getStatus()).isEqualTo("A");
	
	}
	
	@Test
	public void deleteReturnTest(){
		
		Return returnManagement = Return.builder().itemCount(31).invoiceId(1234).custId(1254).itemCode(365).retAmt(1000)
				.qty(2).description("good").Status("A").build();
	
	
				Return saveReturn = returnRepository.save(returnManagement);
	
	returnRepository.deleteById(returnManagement.getReturnId());
	Optional<Return> Optional1 = returnRepository.findById(returnManagement.getReturnId()); // then - verify the output
	Assertions.assertThat(Optional1).isEmpty();
	}

	@Test
	public void findAllTestReturnTest(){
		
	List<Return> returnList = returnRepository.findAll();

	Assertions.assertThat(returnList).isNotNull();
	Assertions.assertThat(returnList.size()).isEqualTo(0);
	}
}

