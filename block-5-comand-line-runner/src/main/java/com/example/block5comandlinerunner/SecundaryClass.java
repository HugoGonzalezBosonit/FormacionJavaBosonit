package com.example.block5comandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class SecundaryClass {

    @Bean
    CommandLineRunner secondExec ()
    {
        return p ->
        {
            System.out.println("Hola desde SecundaryClass");
        };
    }

}
