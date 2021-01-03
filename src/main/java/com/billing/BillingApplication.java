package com.billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BillingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(BillingApplication.class, args);
		
		System.out.println("Welcome to Spring Boot - Billing Application");
	}

}
