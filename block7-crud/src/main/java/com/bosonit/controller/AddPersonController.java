package com.bosonit.controller;

import com.bosonit.application.PersonService;
import com.bosonit.application.PersonServiceImpl;
import com.bosonit.controller.dto.PersonInputDto;
import com.bosonit.controller.dto.PersonOutputDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/Person")
public class AddPersonController {
    @Autowired
    PersonServiceImpl personService;

    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson (@Valid @RequestBody PersonInputDto personInputDto) {
        URI location = URI.create("/Person");
        return ResponseEntity.created(location).body(personService.addPerson(personInputDto));
    }

}
