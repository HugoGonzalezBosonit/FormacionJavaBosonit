package com.bosonit.subject.controller;

import com.bosonit.exceptions.CustomError;
import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.exceptions.UnprocessableEntityException;
import com.bosonit.exceptions.CustomErrorOutputDto;
import com.bosonit.subject.application.SubjectService;
import com.bosonit.subject.controller.dto.SubjectInputDto;
import com.bosonit.subject.controller.dto.SubjectOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @PostMapping
    public SubjectOutputDto añadirAsignatura(@RequestBody SubjectInputDto subjectInputDto) throws EntityNotFoundException {
        return subjectService.añadirAsignatura(subjectInputDto);
    }
    @PostMapping("/subjToStud")
    public SubjectOutputDto añadirAsignaturaAEstudiante(Integer idAsignatura, Integer idEstudiante) throws EntityNotFoundException {
        subjectService.añadirAsignaturaAEstudiante(idAsignatura,idEstudiante);
        return null;
    }
    @GetMapping("/get/{id}")
    public SubjectOutputDto obtenerAsignaturaPorId(@PathVariable Integer id) throws EntityNotFoundException {
        return subjectService.obtenerAsignaturaPorId(id);
    }
    @GetMapping
    public List<SubjectOutputDto> obtenerListaAsignaturas(){
        return subjectService.obtenerAsignaturas();
    }
    @DeleteMapping("/del/{id}")
    public void borrarAsignatura(@PathVariable Integer id) throws Exception {
        subjectService.borrarAsignatura(id);
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
