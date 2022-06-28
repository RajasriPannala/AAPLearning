package com.bourntec.aaplearning.modules.customermanagement.v1.exception;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;

/**
 * @author Sarath G Krishnan
 *
 */
@Data
//@Value
@Getter
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException {
String errorMessage;
}
