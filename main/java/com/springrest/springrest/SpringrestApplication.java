package com.springrest.springrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @ComponentScan(basePackages="com.springrest.springrest")
public class SpringrestApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringrestApplication.class);
	public static void main(String[] args) {
		logger.info("🚀 Spring Boot Application is Starting...");
        SpringApplication.run(SpringrestApplication.class, args);
		logger.info("Spring Boot Application Running. Well Done!!!!");
	}

}


