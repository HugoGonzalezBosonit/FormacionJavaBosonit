package com.bosonit.professor.aplication;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.exceptions.UnprocessableEntityException;
import com.bosonit.professor.controller.dto.input.ProfessorInputDto;
import com.bosonit.professor.controller.dto.output.ProfessorOutputDto;
import com.bosonit.professor.domain.ProfessorEntity;

import java.util.List;

public interface ProfessorService {
    ProfessorOutputDto añadirProfesor(ProfessorInputDto professorInputDto) throws Exception;
    ProfessorOutputDto obtenerProfesorPorId(Integer id) throws EntityNotFoundException;
    List<ProfessorOutputDto> obtenerProfesores();
    void borrarProfesor(Integer id) throws Exception;
}
