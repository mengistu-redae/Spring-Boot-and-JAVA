package com.mengistu.redae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@Configuration
@ComponentScan(basePackages = "com.mengistu")
@EnableAutoConfiguration
 */
@SpringBootApplication //(scanBasePackages={"com.mengistu"})
public class SpringBootRegistrationLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRegistrationLoginApplication.class, args);
	}

}
