package com.springboot.microservices.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication

//@ComponentScan(basePackages = "com.springboot", 
//excludeFilters = @Filter(classes = {UserController.class, UserService.class}) )
public class MicroservicesUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesUserApplication.class, args);
	}

}
