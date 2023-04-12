package com.example.block6pathvariableheaders;

import com.example.block6pathvariableheaders.person.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class Main {

	// PostMapping que pide un JSON y lo devuelve sin cambios
	@PostMapping("/PostJSON")
	public Person addPerson (@RequestBody Person person) {
		return person;
	}
	// GetMapping que pide una ruta determinada y devuelve parte de esa ruta
	@GetMapping("/user/{id}")
	public String id(@PathVariable String id) {
		return id;
	}

	@PutMapping("/PutVars")
	public HashMap<String, Integer> vars(@RequestParam("var1") int var1,
					   @RequestParam("var2") int var2) {
		HashMap<String, Integer> variables = new HashMap<String, Integer>();

		variables.put("var1", var1);
		variables.put("var2", var2);
		return variables;
	}


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
