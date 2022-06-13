package com.bourntec.aaplearning.modules.shippingmanagement.v1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtFilter jwtFilter;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable().addFilterBefore(jwtFilter,
				UsernamePasswordAuthenticationFilter.class);
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		 auth.inMemoryAuthentication()
//		  .withUser("user1").password(getpassword().encode("password")).roles("USER").and()
//		  .withUser("user2").password(getpassword().encode("password2")).roles("ADMIN");
//		}
//
//	@Bean
//	public PasswordEncoder getpassword() {
//	return new BCryptPasswordEncoder();

	}

}
