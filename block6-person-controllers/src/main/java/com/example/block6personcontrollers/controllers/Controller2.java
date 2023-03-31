package com.example.block6personcontrollers.controllers;

import com.example.block6personcontrollers.person.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller2")
public class Controller2 {

    @GetMapping("/getPerson")
    public Person getPerson (@RequestBody Person person) {
        person.setAge(person.getAge() * 2);
        return person;
    }

}
