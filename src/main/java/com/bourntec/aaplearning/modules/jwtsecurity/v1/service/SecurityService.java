package com.bourntec.aaplearning.modules.jwtsecurity.v1.service;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;



public interface SecurityService {
	Claims validateJwtToken(String authToken);
	String generateJwtToken(Authentication authentication);
	String getUserNameFromJwtToken(String token);
//	JwtResponse authenticateUser(LoginRequest loginRequest);
//	JwtResponse registerUser(SignupRequest signUpRequest);

}
