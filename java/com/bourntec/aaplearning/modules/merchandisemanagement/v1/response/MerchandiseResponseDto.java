package com.bourntec.aaplearning.modules.merchandisemanagement.v1.response;

import com.bourntec.aaplearning.entity.Merchandise;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aryalekshmi
 *
 */
@Getter
@Setter
public class MerchandiseResponseDto {
	
	private String status;
	private String responseMessage;
	private Merchandise payload;
	

}
