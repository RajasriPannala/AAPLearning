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
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired

	JwtTokenFilter jwtFilter;

  @Override
  protected void configure(HttpSecurity http) throws Exception {//It tells Spring Security how we configure, when we want to require all users to be authenticated or not, which filter (AuthTokenFilter) and when we want it to work (filter before UsernamePasswordAuthenticationFilter), which Exception Handler is chosen (AuthEntryPointJwt).
    http.cors().and().csrf().disable().addFilterBefore(jwtFilter,
			UsernamePasswordAuthenticationFilter.class)
  //    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .authorizeRequests().antMatchers("/api/auth/**").permitAll()  // Our endpoints
      .antMatchers("/api/test/**").permitAll()
      .antMatchers("/swagger-ui*/**","/v3/api-docs/**")
      .permitAll()
      .anyRequest().authenticated();// Reject every unauthenticated request and send error code 401.

}
}


