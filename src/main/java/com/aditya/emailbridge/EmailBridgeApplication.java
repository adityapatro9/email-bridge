package com.aditya.emailbridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.aditya")
public class EmailBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailBridgeApplication.class, args);
	}

}
