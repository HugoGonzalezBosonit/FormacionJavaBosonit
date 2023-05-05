package com.bosonit.subject.application;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.exceptions.UnprocessableEntityException;
import com.bosonit.subject.controller.dto.SubjectInputDto;
import com.bosonit.subject.controller.dto.SubjectOutputDto;
import com.bosonit.subject.domain.SubjectEntity;

import java.util.List;

public interface SubjectService {
    SubjectOutputDto añadirAsignatura(SubjectInputDto subjectInputDto) throws EntityNotFoundException;

    SubjectOutputDto obtenerAsignaturaPorId(Integer id) throws EntityNotFoundException;

    List<SubjectOutputDto> obtenerAsignaturas();

    void borrarAsignatura(Integer id) throws Exception;
    void añadirAsignaturaAEstudiante(int idAsignatura, int idEstudiante);
}
