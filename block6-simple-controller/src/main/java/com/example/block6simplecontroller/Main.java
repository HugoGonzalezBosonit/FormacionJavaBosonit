package com.example.block6simplecontroller;

import com.example.block6simplecontroller.person.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class Main {

// URL ---> http://localhost:8080/user/[Whatever you willing to put]
	@GetMapping("/user/{name}")
	public String hello(@PathVariable String name) {
		String saludo = "Hola " +name;
		return saludo;
	}
// URL ---> http://localhost:8080/useradd
	@PostMapping(value = "/useradd")
	public Person addUser(@RequestBody Person person) {
		person.setAge(person.getAge() + 1);
		return person;
	}
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
