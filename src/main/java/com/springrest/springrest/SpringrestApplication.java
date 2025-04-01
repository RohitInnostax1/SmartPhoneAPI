package com.springrest.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @ComponentScan(basePackages="com.springrest.springrest")
public class SpringrestApplication {

	public static void main(String[] args) {
		System.out.println("🚀 Spring Boot Application is Starting...");
        SpringApplication.run(SpringrestApplication.class, args);
        System.out.println("✅ Spring Boot Application Started Successfully !");
	}

}
