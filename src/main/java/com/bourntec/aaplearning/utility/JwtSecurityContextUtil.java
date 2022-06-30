package com.bourntec.aaplearning.utility;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class JwtSecurityContextUtil {
	private String currentUser;

}
