package com.bourntec.aaplearning.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;








/**
 * @author Jeena Thomas
 *
 */
@Configuration
@EnableWebSecurity //allows Spring to find and automatically apply the class to the global Web Security.
@EnableGlobalMethodSecurity(prePostEnabled = true)//provides  security on methods. It enables @PreAuthorize, @PostAuthorize
  
   
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {//It tells Spring Security how we configure, when we want to require all users to be authenticated or not, which filter (AuthTokenFilter) and when we want it to work (filter before UsernamePasswordAuthenticationFilter), which Exception Handler is chosen
  

//  @Autowired
//  private AuthEntryPointJwt unauthorizedHandler;
//  
  @Autowired
  private JwtTokenFilter jwtTokenFilter;


  /**
   * This method to authenticate based on a token
 * @return
 */
//@Bean
// public AuthTokenFilter authenticationJwtTokenFilter() {
//   return new AuthTokenFilter();
// }
  

// @Bean
//@Override
//public AuthenticationManager authenticationManagerBean() throws Exception {
//  return super.authenticationManagerBean();
//}

  @Override
  protected void configure(HttpSecurity http) throws Exception {//It tells Spring Security how we configure, when we want to require all users to be authenticated or not, which filter (AuthTokenFilter) and when we want it to work (filter before UsernamePasswordAuthenticationFilter), which Exception Handler is chosen (AuthEntryPointJwt).
    http.cors().and().csrf().disable()
  //    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .authorizeRequests().antMatchers("/api/auth/**").permitAll()  // Our endpoints
     .antMatchers("/api/test/**").permitAll()
//      .antMatchers("/orders/**").permitAll()

      .anyRequest().authenticated();// Reject every unauthenticated request and send error code 401.

    http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);// Add a filter to validate the tokens with every request
  }
 
  
   
}