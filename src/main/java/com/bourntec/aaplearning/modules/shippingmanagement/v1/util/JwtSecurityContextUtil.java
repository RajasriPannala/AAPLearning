package com.bourntec.aaplearning.modules.shippingmanagement.v1.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Component
@Getter
@Setter
public class JwtSecurityContextUtil {
	
	public JwtSecurityContextUtil() {
		// TODO Auto-generated constructor stub
	}
	private String id;
	private Date currentDate;

}
