package com.bourntec.aaplearning.modules.returnmanagement.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sarath G Krishnan
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnListResponseDTO {

	String responsemessage;
	Object payload;
	String Status;

}
