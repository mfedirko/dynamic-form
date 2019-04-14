package com.example.exmpl1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.exmpl1.dao")
@EntityScan(basePackages = "com.example.exmpl1.entity")
@ComponentScan(basePackages = "com.example.exmpl1")
public class Exmpl1Application {

	public static void main(String[] args) {
		SpringApplication.run(Exmpl1Application.class, args);
	}

}
