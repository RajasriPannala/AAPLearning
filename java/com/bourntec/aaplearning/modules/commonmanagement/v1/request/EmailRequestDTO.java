package com.bourntec.aaplearning.modules.commonmanagement.v1.request;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequestDTO {
	
	private String toMail;
	private String subject;
	private String message;
	private String module;//payment
	private String  keyValue;//id
	

}
