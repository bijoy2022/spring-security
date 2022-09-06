package com.myproject.springsecurity.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.springsecurity.model.User;
@RestController
public class DefaultController {
	
	private static final Logger LOGGER = LogManager.getLogger(DefaultController.class);
	
	@PreAuthorize("hasAuthority('ROLE_USER')") 
	@PostMapping("/fetch")
			public @ResponseBody String fetchUser(@RequestBody User user) {
				LOGGER.info("getUser called ----------------");
				System.out.println("login post method called...................");
				System.out.println("User name password and enabled is "+user.getUsername()+"   " +user.getPassword()+"  "+user.isEnabled());

				return "sucess";

			}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") 
	@PutMapping("/update")
	public @ResponseBody String updateUser(@RequestBody User user) {
		LOGGER.info("getUser called ----------------");
		
		System.out.println("login put method called...................");
		System.out.println("User name password and enabled is "+user.getUsername()+"   " +user.getPassword()+"  "+user.isEnabled());
		return "sucess";

	}
	
	@GetMapping("/checkHealth")
	public @ResponseBody String getEmployee() {
		System.out.println("checkHealth called ..................");
		return "checkHealth called successfully";

	}

}
