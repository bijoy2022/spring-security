package com.myproject.springsecurity.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfig 
{
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * System.out.println("Security started----"); http .csrf().disable()
	 * .authorizeRequests().anyRequest().authenticated() .and() .httpBasic(); }
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception { auth.inMemoryAuthentication() .withUser("admin")
	 * .password("{noop}password") .roles("USER"); }
	 */
}
