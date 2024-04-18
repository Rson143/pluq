package com.pluq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pluq"})
public class PluqApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluqApplication.class, args);
	}

}
