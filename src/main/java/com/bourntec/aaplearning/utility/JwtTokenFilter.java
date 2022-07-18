package com.bourntec.aaplearning.utility;



import java.io.IOException;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;



@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
	JwtSecurityContextUtil contextUtil;

    RestTemplate restTemplate=new RestTemplate();

	@Value("${jwt.decode.url}")
	private String decodeUrl;



	/**
	 * This method  that  will implement parsing & validating JWT, loading User details and checking Authorizaion
	 */
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//					 HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//					 HttpServletResponse httpServletResponse = (HttpServletResponse) response;


		if(httpServletRequest.getHeader("AUTHORIZATION")!=null) {
			URI uri = null;
			try {
				uri=new URI(decodeUrl);
			}catch(URISyntaxException e) {
				e.printStackTrace();
			}
			HttpHeaders headers=new HttpHeaders();
			headers.set("AUTHORIZATION",httpServletRequest.getHeader("AUTHORIZATION"));

			HttpEntity<Void> entity= new HttpEntity<>(headers);
			ResponseEntity<String> decodeResponse=restTemplate.exchange( uri, HttpMethod.GET,entity, String.class);
            System.out.println(decodeResponse.getBody());
            
            String claims=decodeResponse.getBody();
            
           
			if (claims.contains("success")){
			//if (Objects.nonNull(decodeResponse)) {
				JSONObject json = XML.toJSONObject(decodeResponse.getBody());
				
			String userName=json.getJSONObject("Claims").getString("username");
				

				final List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
				String username=getFilterName() != null ? getFilterName().trim() : "";
				contextUtil.setCurrentUser(userName);
			
			UsernamePasswordAuthenticationToken authentication =new UsernamePasswordAuthenticationToken(username,null, grantedAuthorities);
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			else {
				httpServletResponse.setStatus(401);
					return;
			}
			
			//			return;
				
            //	if (Objects.nonNull(decodeResponse)) {
			//			Map filterResult = objectMapper.readValue(decodeResponse.getBody(),Map.class);
			//		jwtSecurityContext.setId((String) filterResult.get("id"));
			//		httpServletResponse.setStatus(200);
			//		}else {
			//			httpServletResponse.setStatus(401);
			//			return;
			//		}
			}
		


		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}

