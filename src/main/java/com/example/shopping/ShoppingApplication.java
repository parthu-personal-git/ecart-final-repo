package com.example.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.shopping"})
@EntityScan("com.example.shopping.model")
@EnableJpaRepositories
public class ShoppingApplication {

	public static void main(String[] args) {
		System.out.println("hi from main");
		SpringApplication.run(ShoppingApplication.class, args);
	}

}
