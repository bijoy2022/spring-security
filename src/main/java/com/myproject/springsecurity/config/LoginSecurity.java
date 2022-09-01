package com.myproject.springsecurity.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class LoginSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
    DataSource dataSource;

	//Enable jdbc authentication
	
	  @Autowired public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception 
	  { 
		  auth.jdbcAuthentication().dataSource(dataSource);
	  }
	 
    
    
	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/resources/**"); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN").antMatchers("/addNewEmployee")
				.hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.and().logout().permitAll();

		http.csrf().disable();
	}

}
