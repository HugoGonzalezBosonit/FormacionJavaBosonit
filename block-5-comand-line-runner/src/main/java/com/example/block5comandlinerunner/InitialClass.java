package com.example.block5comandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class InitialClass {

    @Bean
    CommandLineRunner firstExec ()
    {
        return p ->
        {
            System.out.println("Hola desde InitialClass");
        };
    }

}
