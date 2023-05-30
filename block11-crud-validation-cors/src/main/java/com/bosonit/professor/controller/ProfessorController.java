package com.bosonit.professor.controller;

import com.bosonit.exceptions.CustomError;
import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.exceptions.UnprocessableEntityException;
import com.bosonit.exceptions.CustomErrorOutputDto;
import com.bosonit.professor.aplication.ProfessorService;
import com.bosonit.professor.controller.dto.input.ProfessorInputDto;
import com.bosonit.professor.controller.dto.output.ProfessorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;
    @PostMapping
    public ProfessorOutputDto añadirProfesor(@RequestBody ProfessorInputDto professorInputDto) throws Exception {
        return professorService.añadirProfesor(professorInputDto);
    }
    @GetMapping("/get/{id}")
    public ProfessorOutputDto obtenerProfesorPorId(@PathVariable Integer id) throws EntityNotFoundException {
        return professorService.obtenerProfesorPorId(id);
    }
    @GetMapping
    public List<ProfessorOutputDto> obtenerListaProfesores(){
        return professorService.obtenerProfesores();
    }
    @DeleteMapping("/del/{id}")
    public void borrarProfesor(@PathVariable Integer id) throws Exception {
        professorService.borrarProfesor(id);
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
