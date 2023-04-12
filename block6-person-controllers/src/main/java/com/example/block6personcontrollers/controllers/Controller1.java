package com.example.block6personcontrollers.controllers;

import com.example.block6personcontrollers.person.Person;
import com.example.block6personcontrollers.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/controller1")
public class Controller1 {

    @Autowired
    private PersonService personService;

    @GetMapping("/addPerson")
    private Person addPerson (@RequestParam("name") String name,
                              @RequestParam("population") String population,
                              @RequestParam("age") int age) {
        return personService.createPerson(name, population, age);
    }
}
