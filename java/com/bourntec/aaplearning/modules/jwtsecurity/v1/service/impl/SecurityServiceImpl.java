package com.bourntec.aaplearning.modules.jwtsecurity.v1.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.ERole;
import com.bourntec.aaplearning.entity.Role;
import com.bourntec.aaplearning.entity.User;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.controller.AuthenticationController;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.repository.RoleRepository;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.repository.UserRepository;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.request.LoginRequest;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.request.SignupRequest;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.response.JwtResponse;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.response.MessageResponse;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.service.SecurityService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class SecurityServiceImpl implements SecurityService {
	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
	 @Autowired
	  AuthenticationManager authenticationManager;
	 @Autowired
	 UserRepository userRepository;
	  @Autowired
	  PasswordEncoder encoder;
	  @Autowired
	  RoleRepository roleRepository;
	
	@Value("${jwt.Secret}")
	  private String jwtSecret;

	@Value("${jwt.ExpirationMs}")
	  private int jwtExpirationMs;

	@Override
	public String validateJwtToken(String authToken)  {
		 try {
			 authToken=authToken.replace("Bearer ","");
			 Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			 return "success";
			 
		    } catch (SignatureException e) {
		      logger.error("Invalid JWT signature: {}", e.getMessage());
		    } catch (MalformedJwtException e) {
		      logger.error("Invalid JWT token: {}", e.getMessage());
		    } catch (ExpiredJwtException e) {
		      logger.error("JWT token is expired: {}", e.getMessage());
		    } catch (UnsupportedJwtException e) {
		      logger.error("JWT token is unsupported: {}", e.getMessage());
		    } catch (IllegalArgumentException e) {
		      logger.error("JWT claims string is empty: {}", e.getMessage());
		    }
		    return "fail";
		  }

	@Override
	public String generateJwtToken(Authentication authentication) {
		// TODO Auto-generated method stub
		 UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		 Map<String, Object> claims = new HashMap<>();
		    return Jwts.builder()
		        .setSubject((userPrincipal.getUsername()))
		        .setClaims(claims)
		        .setIssuedAt(new Date())
		        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
		        .signWith(SignatureAlgorithm.HS512, jwtSecret)
		        .compact();
	}

	@Override
	public String getUserNameFromJwtToken(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	@Override
	public ResponseEntity<JwtResponse> signin(@Valid LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		    SecurityContextHolder.getContext().setAuthentication(authentication);
		    String jwt = generateJwtToken(authentication);
		    
		    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
		    List<String> roles = userDetails.getAuthorities().stream()
		        .map(item -> item.getAuthority())
		        .collect(Collectors.toList());
		    log.info("generating token");

		    return ResponseEntity.ok(new JwtResponse(jwt, 
		                         userDetails.getId(), 
		                         userDetails.getUsername(), 
		                         userDetails.getEmail(), 
		                         roles));
	}

	@Override
	public ResponseEntity<?> signup(@Valid SignupRequest signUpRequest) {
		// TODO Auto-generated method stub
		 if (userRepository.existsByUsername(signUpRequest.getUsername())) {
		      return ResponseEntity
		          .badRequest()
		          .body(new MessageResponse("Error: Username is already taken!"));
		    }

		    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
		      return ResponseEntity
		          .badRequest()
		          .body(new MessageResponse("Error: Email is already in use!"));
		    }

		    // Create new user's account
		    User user = new User(signUpRequest.getUsername(), 
		               signUpRequest.getEmail(),
		               encoder.encode(signUpRequest.getPassword()));

		    Set<String> strRoles = signUpRequest.getRole();
		    Set<Role> roles = new HashSet<>();

		    if (strRoles == null) {
		      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
		          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		      roles.add(userRole);
		    } else {
		      strRoles.forEach(role -> {
		        switch (role) {
		        case "admin":
		          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
		              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		          roles.add(adminRole);

		          break;
		        case "mod":
		          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
		              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		          roles.add(modRole);

		          break;
		        default:
		          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
		              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		          roles.add(userRole);
		        }
		      });
		    }

		    user.setRoles(roles);
		    userRepository.save(user);

		    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		  }

}

