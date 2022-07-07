package com.bourntec.aaplearning.modules.customermanagement.v1.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.utility.JwtSecurityContextUtil;

//@Service
public class AuditorAwareImpl implements AuditorAware<String> {
//@Autowired
//JwtTokenFilter token;
//@Autowired
//SecurityServiceImpl securityService;
@Autowired
	JwtSecurityContextUtil contextUtil;

	@Override
	public Optional<String> getCurrentAuditor() {
		//return Optional.of("sarath");
	return Optional.of(contextUtil.getCurrentUser());
	//	return Optional.of(securityService.validateJwtToken(null).getAudience());
	}

}
