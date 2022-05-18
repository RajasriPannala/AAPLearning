package com.bourntec.aaplearning.modules.ordermanagement.v1.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
//@Setter
//@Data

@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException{
	
		
		String errorMessage;

	}



