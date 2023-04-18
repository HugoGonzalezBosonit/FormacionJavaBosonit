package com.bosonit.controller;

import com.bosonit.application.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
public class DeletePersonByIdController {

    @Autowired
    PersonServiceImpl personService;

    @DeleteMapping
    public ResponseEntity<String> deletePersonById (@RequestParam int id) {
        try {
            personService.deletePersonById(id);
            return ResponseEntity.ok().body("La persona con la id: " +id+ " ha sido eliminada de la base de datos");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
