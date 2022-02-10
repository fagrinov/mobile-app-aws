package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.ui.controller.UserController;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
@ComponentScan("com.example.demo.service")
public class MobileAppAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppAwsApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
