package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.product")
@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class HomapsApplication {

	public static void main(String[] args) {

		SpringApplication.run(HomapsApplication.class, args);

	}
}
