
package com.myproject.springsecurity.config;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class LoginSecurity extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LogManager.getLogger(LoginSecurity.class);

	 @Autowired
	 DataSource dataSource;

	// Enable jdbc authentication

	@Bean
	public PasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info("configAuthentication");
		System.out.println("configAuthentication");
		Connection conn = dataSource.getConnection();
		System.out.println("Schema name is :: " + conn.getSchema());

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password,'true' as enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
				.passwordEncoder((NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance());

		/*
		 * auth.jdbcAuthentication().passwordEncoder(new
		 * BCryptPasswordEncoder()).dataSource(dataSource)
		 * .usersByUsernameQuery("select username, password, enabled from users where username=?"
		 * )
		 * .authoritiesByUsernameQuery("select username, role from users where username=?"
		 * );
		 */

		// auth.inMemoryAuthentication().withUser("user").password("{noop}password").
	}

	/*
	 * @Autowired public void configAuthentication(AuthenticationManagerBuilder
	 * auth) throws Exception { auth.jdbcAuthentication().passwordEncoder(new
	 * BCryptPasswordEncoder()).dataSource(dataSource)
	 * .usersByUsernameQuery("select username, password, enabled from users where username=?"
	 * )
	 * .authoritiesByUsernameQuery("select username, role from users where username=?"
	 * ); }
	 */

	

	@Override protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure called...........");
		//http.csrf().disable().authorizeRequests().anyRequest().hasAuthority("ROLE_USER");
		/*
		 * http.cors().and().csrf().disable().authorizeRequests()
		 * .antMatchers("/").hasAnyRole("ROLE_USER","ROLE_ADMIN").anyRequest().
		 * authenticated();
		 */
		
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/")
         .hasAnyRole("FAILED","FAILED").anyRequest().authenticated().and().httpBasic();
		
 
  }

}
