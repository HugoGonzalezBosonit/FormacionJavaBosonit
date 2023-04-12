package com.example.block6pathvariableheaders.person;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Person {
    private String id;
    private String name;
    private String city;
    private int age;

    private String var1;
}
