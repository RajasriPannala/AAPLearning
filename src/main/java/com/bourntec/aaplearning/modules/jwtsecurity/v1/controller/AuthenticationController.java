package com.bourntec.aaplearning.modules.jwtsecurity.v1.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.ERole;
import com.bourntec.aaplearning.entity.Role;
import com.bourntec.aaplearning.entity.User;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.repository.RoleRepository;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.repository.UserRepository;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.request.LoginRequest;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.request.SignupRequest;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.response.JwtResponse;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.response.MessageResponse;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.service.SecurityService;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.service.impl.UserDetailsImpl;

import lombok.extern.slf4j.Slf4j;





/**
 * @author Jeena Thomas
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthenticationController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  SecurityService securityService;

  /**
 * @param loginRequest
 * @return
 */
@PostMapping("/signin")
  public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	return securityService.signin(loginRequest);
    
  }

  /**
 * @param signUpRequest
 * @return
 * @throws Exception 
 */
@GetMapping("/decode")
public String decodeToken(@RequestHeader("AUTHORIZATION") String token)   {
	log.info("validating token");
	return securityService.validateJwtToken(token);

}
@PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	return securityService.signup(signUpRequest);
   
}
}