package com.example.block6personcontrollers.person;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person createPerson(String name, String population, int age) {

        return new Person(name, population, age);

    }

}
