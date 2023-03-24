package com.example.block5comandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

	@Bean
	CommandLineRunner firstExec ()
	{
		return p ->	System.out.println("Hola desde InitialClass");
	}


	@Bean
	CommandLineRunner secondExec ()
	{
		return p ->	System.out.println("Hola desde SecundaryClass");
	}

	@Bean
	CommandLineRunner thirdExec ()
	{
		return p -> System.out.println("Soy la tercera Class");
	}

}
