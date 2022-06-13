package com.bourntec.aaplearning.modules.shippingmanagement.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException {

	String errorMessage;
}
