package com.bosonit.controller;

import com.bosonit.application.PersonServiceImpl;
import com.bosonit.controller.dto.PersonOutputDto;
import com.bosonit.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Person")
public class ConsultPersonController {

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonOutputDto> consultPersonById (@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personService.consultPersonById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/Nombre/{nombre}")
    public List<Person> consultPersonByName (@PathVariable String nombre) {
//        try {
//            return ResponseEntity.ok().body(personService.consultPersonByName(nombre));
//        } catch (Exception e) {
//            return ResponseEntity.ok().build();
//        }
        return personService.consultPersonByName(nombre);
    }

    @GetMapping
    public Iterable<PersonOutputDto> consultAllPeople (@RequestParam(defaultValue = "0", required = false) int pageNumber,
                                                       @RequestParam(defaultValue = "10", required = false) int pageSize) {
        return personService.consultAllPeople(pageNumber, pageSize);
    }

}
