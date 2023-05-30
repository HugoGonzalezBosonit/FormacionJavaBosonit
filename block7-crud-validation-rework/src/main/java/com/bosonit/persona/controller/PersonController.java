package com.bosonit.persona.controller;

import com.bosonit.exceptions.CustomError;
import com.bosonit.exceptions.CustomErrorOutputDto;
import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.exceptions.UnprocessableEntityException;
import com.bosonit.persona.application.PersonService;
import com.bosonit.persona.controller.dto.input.PersonInputDto;
import com.bosonit.persona.controller.dto.output.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping
    public PersonOutputDto añadirPersona(@RequestBody PersonInputDto personaInputDto) throws Exception {
        return personService.añadirPersona(personaInputDto);
    }
    @GetMapping("/{usuario}")
    public PersonOutputDto obtenerPersonaPorNombre(@PathVariable String usuario){
        return personService.obtenerPersonaPorUsuario(usuario);
    }
    @GetMapping("/get/{id}")
    public PersonOutputDto obtenerPersonaPorId(@PathVariable Integer id) throws EntityNotFoundException {
        return personService.obtenerPersonaPorId(id);
    }
    @GetMapping
    public List<PersonOutputDto> obtenerListaPersonas(){
        return personService.obtenerPersonas();
    }

    @DeleteMapping("/del/{id}")
    public void borrarPersona(@PathVariable Integer id) throws Exception {
        personService.borrarPersona(id);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomErrorOutputDto> handleEntityNotFoundException(EntityNotFoundException e) {
        CustomError customError = new CustomError();
        customError.setHttpCode(HttpStatus.NOT_FOUND.value());
        customError.setMensaje(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError.customErrorToCustomErrorOutputDto());
    }
    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomErrorOutputDto> handleUnprocessableEntityException(UnprocessableEntityException e) {
        CustomError customError = new CustomError();
        customError.setHttpCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        customError.setMensaje(e.getMessage());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customError.customErrorToCustomErrorOutputDto());
    }
}
