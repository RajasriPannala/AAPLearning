package com.bourntec.aaplearning.modules.paymentmanagement.v1.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
	
	private String key;
    private Object value;
    private SearchOperations operation;


}
