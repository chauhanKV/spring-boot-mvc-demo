package com.example.springbootmvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMvcDemoApplication {

	// This SpringBoot Application creates bean of ProductController and ProductService
	// As opposed to what we need manually in local spring application. SpringBoot Automates it.
	// This is a annotation based project ( earlier we did xml based bean injection using spring , this is annotation based injection using springboot)
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcDemoApplication.class, args);
	}

}
