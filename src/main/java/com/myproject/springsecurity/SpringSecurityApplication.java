package com.myproject.springsecurity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringSecurityApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(SpringSecurityApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		
		
		/*
		 * @Value("${spring.application.name}") private String name;
		 */
		LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
		
		
	}

}
