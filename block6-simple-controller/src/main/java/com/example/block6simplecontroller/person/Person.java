package com.example.block6simplecontroller.person;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Person {
    private String name;
    private String city;
    private int age;
}
