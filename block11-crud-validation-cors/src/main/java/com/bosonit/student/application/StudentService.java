package com.bosonit.student.application;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.student.controller.dto.input.StudentInputDto;
import com.bosonit.student.controller.dto.output.StudentFullOutputDto;
import com.bosonit.student.controller.dto.output.StudentOutputDto;
import com.bosonit.student.controller.dto.output.StudentSimpleOutputDto;

import java.util.List;

public interface StudentService {
    StudentOutputDto añadirEstudiante(StudentInputDto studentInputDto) throws Exception;

    StudentSimpleOutputDto obtenerEstudianteSimplePorId(Integer id, String outputType) throws EntityNotFoundException;
    StudentFullOutputDto obtenerEstudianteFullPorId(Integer id, String outputType) throws EntityNotFoundException;

    List<StudentOutputDto> obtenerEstudiantes();

    void borrarEstudiante(Integer id) throws Exception;
}