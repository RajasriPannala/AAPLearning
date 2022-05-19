package com.bourntec.aaplearning.modules.returnmanagement.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException{
	String errorMessage;
}
