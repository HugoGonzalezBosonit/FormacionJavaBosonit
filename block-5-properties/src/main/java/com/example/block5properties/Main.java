package com.example.block5properties;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
	@Value("${greeting}")
	private String greeting;

	@Value("${my.number}")
	private int num;

	@Value("${new.propertie:new.propertie no tiene valor}")
	private String nprop;


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);



	}

	@Bean
	public void imprimeStr() {
		System.out.println("El valor de greeting es: " +greeting);
	}
	@Bean
	public void imprimeInt() {
		System.out.println("El valor de my.number es: " +num);
	}
	@PostConstruct
	public void imprimeNonValued() {
		System.out.println("El valor de new.property es: " +nprop);
	}

}
