package com.bourntec.aaplearning.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bourntec.aaplearning.entity.Return;
import com.bourntec.aaplearning.modules.returnmanagement.v1.repository.ReturnRepository;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl.CustomReturnServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestReturn {
	@InjectMocks
	CustomReturnServiceImpl customReturnService;
	@Mock
	ReturnRepository returnRepository;
	
	@BeforeEach
	public void init() {
		Mockito.when(returnRepository.findById(anyInt())).thenReturn(Optional.ofNullable(new Return(10,10,10,10,10,9,10,"good","A")));
		}

	
	@Test
	void test() {
//		Mockito.when(ReturnRepository.findById(any())).thenReturn(Optional.ofNullable(new Return(10,10,10,10,10,10,10,"good","A")));
		assertEquals("below",customReturnService.findByRetAmt(1));
	}
}
