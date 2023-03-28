package com.example.block5properties;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	// Determino una variable local a los valores de las líneas asignadas en aplication.properties
	// Tambi,en asigno un valor por defecto en caso de que de algún tipo de error
	@Value("${greeting:greeting no tiene valor}")
	private String greeting;
	@Value("${my.number:my.number no tiene valor}")
	private static int num;

	// private static int num;
	// Al poner static no es capaz de asignarle el valor que se encuentra en application.properties
	@Value("${new.propertie:new.propertie no tiene valor}")
	private String nprop;


	public static void main(String[] args) {
		// Inicialización de SpringBoot
		SpringApplication.run(Main.class, args);

		// System.out.println(num);
		// Sólo sería válido si num es static, pero esto conlleva que el valor sea 0 en int y null en String
	}

	// Como @Value no es static busqué una manera de imprimirlos y se me ocurrieron los @Beam
	@Bean
	public void imprimeStr() {
		System.out.println("El valor de greeting es: " +greeting);
	}
	@Bean
	public void imprimeInt() {
		System.out.println("El valor de my.number es: " +num);
	}
	// Este @PostConstruct es simplemente para jugar con el orden
	@PostConstruct
	public void imprimeNonValued() {
		System.out.println("El valor de new.property es: " +nprop);
	}

}