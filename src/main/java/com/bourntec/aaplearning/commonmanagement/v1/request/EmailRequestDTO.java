package com.bourntec.aaplearning.commonmanagement.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequestDTO {
	
	
	private String toMail;
	private String subject;
	private String module;
	private String message;
	private Integer keyValue;

}
