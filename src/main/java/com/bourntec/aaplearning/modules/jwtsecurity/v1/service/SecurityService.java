package com.bourntec.aaplearning.modules.jwtsecurity.v1.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.bourntec.aaplearning.modules.jwtsecurity.v1.request.LoginRequest;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.request.SignupRequest;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.response.JwtResponse;



public interface SecurityService {
	String validateJwtToken(String authToken);
	String generateJwtToken(Authentication authentication);
	String getUserNameFromJwtToken(String token);
//	JwtResponse authenticateUser(LoginRequest loginRequest);
//	JwtResponse registerUser(SignupRequest signUpRequest);
	ResponseEntity<JwtResponse> signin(@Valid LoginRequest loginRequest);
	ResponseEntity<?> signup(@Valid SignupRequest signUpRequest);

}
