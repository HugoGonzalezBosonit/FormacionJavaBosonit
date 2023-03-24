package com.example.block5comandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class ThirdClass {
    @Bean
    CommandLineRunner thirdExec ()
    {
        return p ->
        {
            System.out.println("Soy la tercera Class");
        };
    }
}
