package com.bourntec.aaplearning.modules.paymentmanagement.v1.search;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchRequest {
	
	Operation Operation;

	String field,value;
	
}
