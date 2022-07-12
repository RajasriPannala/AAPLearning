package com.bourntec.aaplearning.modules.returnmanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Return;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rohini P M
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResponseDTO {
	String responsemessage;
	Object payload;
	String status;



	public ReturnResponseDTO(Return returnManagement) {
	BeanUtils.copyProperties(returnManagement, this);



	}

}

