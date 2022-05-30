package com.bourntec.aaplearning.modules.invoicemanagement.v1.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

/**
 * @author Esther Tomy
 *
 */
@Getter
//@Setter
//@Data

@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException{
	
		
		String errorMessage;

	}



