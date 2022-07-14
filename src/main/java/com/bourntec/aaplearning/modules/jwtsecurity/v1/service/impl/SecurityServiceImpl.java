package com.bourntec.aaplearning.modules.jwtsecurity.v1.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.modules.jwtsecurity.v1.repository.UserRepository;
import com.bourntec.aaplearning.modules.jwtsecurity.v1.service.SecurityService;
import com.bourntec.aaplearning.utility.JwtSecurityContextUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class SecurityServiceImpl implements SecurityService {
	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
//	@Autowired
//	JwtSecurityContextUtil contextUtil;
	
	@Value("${jwt.Secret}")
	  private String jwtSecret;

	@Value("${jwt.ExpirationMs}")
	  private int jwtExpirationMs;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Claims validateJwtToken(String authToken)  {
		Claims claims=null;
				authToken=authToken.replace("Bearer ","");
		 try {
				  claims=Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody();

				  claims.put("status","success");
				  
		 return  claims;
		 
//			 Map<String, Object> claims = new HashMap<>();
//			  claims = Jwts.parser()
//		                .setSigningKey(jwtSecret)
//		                .parseClaimsJws(authToken)
//		                .getBody();
//
//		        return (claims.getSubject());
//		    
              
              
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
		  //  return "fail";
		return null;
		  }
	

	@Override
	public String generateJwtToken(Authentication authentication) {

		 UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		 Map<String, Object> claims = new HashMap<>();
		 claims.put("username", userPrincipal.getUsername());
		 
		// claims.put("role", userPrincipal.);
		    return Jwts.builder()
		        .setSubject((userPrincipal.getUsername()))
		        .setClaims(claims)
		        .setIssuedAt(new Date())
		        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
		        .signWith(SignatureAlgorithm.HS512, jwtSecret)
		        .compact();
		    
		    
		    
		   
	
//		    userSchema.methods.generateJwtToken = function() { 
//		    	const token = jwt.sign( { _id: this._id,
//		    	                          isAdmin: this.isAdmin,
//		    	                          _username:this.username }, 
//		    	 config.get("jwtPrivateKey") ); 
//		    	 return token; 
//		    	}
	}
	

	@Override
	public
	
	String getUserNameFromJwtToken(String token) {



		// TODO Auto-generated method stub

		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
}

