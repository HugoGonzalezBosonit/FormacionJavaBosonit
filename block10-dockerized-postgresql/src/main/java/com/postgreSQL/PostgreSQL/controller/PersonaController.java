package com.postgreSQL.PostgreSQL.controller;

import com.postgreSQL.PostgreSQL.application.PersonaService;
import com.postgreSQL.PostgreSQL.controller.dto.PersonaInputDto;
import com.postgreSQL.PostgreSQL.controller.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> añadirPersona(@RequestParam PersonaInputDto personaInputDto) {
        URI location = URI.create("/persona");
        return ResponseEntity.created(location).body(personaService.añadirPersona(personaInputDto));
    }

    @PutMapping
    public ResponseEntity<PersonaOutputDto> actualizarPersona(@RequestBody PersonaInputDto personaInputDto) {
        try {
            personaService.obtenerPersonaPorId(personaInputDto.getId());
            PersonaOutputDto personaOutputDto = personaService.actualizarPersona(personaInputDto);
            return new ResponseEntity<>(personaOutputDto, HttpStatus.OK);
        } catch (Exception e) {
            System.out.printf("Persona no encontrada");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersonaPorId(@PathVariable int id) {
        try {
            personaService.eliminarPersonaPorId(id);
            return ResponseEntity.ok().body("La persona con id " +id+ " fue eliminado de la base de datos");
        } catch (Exception e) {
            System.out.println("La persona con la id " +id+ " no se encuentra en la base de datos");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> obtenerPersonaPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personaService.obtenerPersonaPorId(id));
        } catch (Exception e) {
            System.out.println("La id: " +id+ " no se encuentra registrada en la base de datos");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<PersonaOutputDto> obtenerPersonaPorId(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok().body(personaService.obtenerPersonaPorNombre(nombre));
        } catch (Exception e) {
            System.out.println("La persona: " +nombre+ " no se encuentra registrada en la base de datos");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Iterable<PersonaOutputDto> obtenerTodasPersonas(@RequestParam(defaultValue = "0", required = false) int pagNum,
                                                           @RequestParam(defaultValue = "4", required = false) int pageSize) {
        return personaService.obtenerPersonas(pagNum, pageSize);
    }
}
