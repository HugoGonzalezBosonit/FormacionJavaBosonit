package com.bosonit.student.controller;

import com.bosonit.exceptions.CustomError;
import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.exceptions.UnprocessableEntityException;
import com.bosonit.exceptions.CustomErrorOutputDto;
import com.bosonit.student.application.StudentService;
import com.bosonit.student.controller.dto.input.StudentInputDto;
import com.bosonit.student.controller.dto.output.StudentOutputDto;
import com.bosonit.student.controller.dto.output.StudentSimpleOutputDto;
import com.bosonit.student.domain.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public StudentOutputDto añadirEstudiante(@RequestBody StudentInputDto studentInputDto) throws Exception {
        return studentService.añadirEstudiante(studentInputDto);
    }
    @GetMapping("/{id}")
    public StudentSimpleOutputDto obtenerEstudiantePorId(@PathVariable Integer id, @RequestParam(name = "outputType") String outputType) throws EntityNotFoundException {
        if (outputType.equalsIgnoreCase("simple")){
            return studentService.obtenerEstudianteSimplePorId(id, outputType);
        }else
            return studentService.obtenerEstudianteFullPorId(id, outputType);
    }
    @GetMapping("/")
    public List<StudentOutputDto> obtenerListaEstudiantes(){
        return studentService.obtenerEstudiantes();
    }
    @DeleteMapping("/{id}")
    public void borrarEstudiante(@PathVariable Integer id) throws Exception {
        studentService.borrarEstudiante(id);
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
