package com.bourntec.aaplearning.modules.ordermanagement.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Karthika J
 *
 */

@Getter
@AllArgsConstructor

/**
I*custom class for exception
 */
public class RecordNotFoundException extends RuntimeException {

	String errorMessage;

}
