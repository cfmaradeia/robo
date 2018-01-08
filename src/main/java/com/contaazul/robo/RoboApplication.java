package com.contaazul.robo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.contaazul")
public class RoboApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoboApplication.class, args);
	}
}
