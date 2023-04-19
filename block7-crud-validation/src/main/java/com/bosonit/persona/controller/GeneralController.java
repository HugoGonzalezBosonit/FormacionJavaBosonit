package com.bosonit.persona.controller;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.persona.application.PersonServiceImpl;
import com.bosonit.persona.controller.dto.PersonInputDto;
import com.bosonit.persona.controller.dto.PersonOutputDto;
import com.bosonit.persona.domain.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/person")
public class GeneralController {

    @Autowired
    PersonServiceImpl personServiceImp;

    // Al añadir personas utilizando un JSON mediante PostMan no puedo obviar los campos de la tabla que sean NotNull, pero sí
    // que puedo pasar Strings vacíos, que al fin y al cabo son basicamente lo mismo (Salvando que a la hora de hacer búsquedas
    // no voy a tener ningún valor nulo sino "" un String vacío.
    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson (@Valid @RequestBody PersonInputDto personInputDto) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personServiceImp.addPerson(personInputDto));
    }

    @GetMapping("/{id}")
    public PersonOutputDto findById (@PathVariable int id) throws EntityNotFoundException {
        return personServiceImp.findById(id);
    }

    @GetMapping("/user/{usuario}")
    public List<Person> findByUsuario (@PathVariable String usuario) {
        return personServiceImp.findByUsuario(usuario);
    }

    @GetMapping
    public List<Person> findAllOnDataBase () {
        return personServiceImp.findAllOnDataBase();
    }
}
