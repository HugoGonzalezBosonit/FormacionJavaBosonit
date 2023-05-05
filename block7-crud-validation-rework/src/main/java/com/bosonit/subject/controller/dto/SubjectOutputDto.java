package com.bosonit.subject.controller.dto;

import com.bosonit.student.domain.StudentEntity;
import com.bosonit.subject.domain.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectOutputDto {
    private Integer idAsignatura;
    private String asignatura;
    private String comentarios;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Integer> estudiantes = new ArrayList<>();
    public SubjectOutputDto(SubjectEntity subject){
        setIdAsignatura(subject.getIdAsignatura());
        setAsignatura(subject.getAsignatura());
        setComentarios(subject.getComentarios());
        setFechaInicial(subject.getFechaFinal());
        setFechaFinal(subject.getFechaFinal());

        // set/get para un array
        List<Integer> students = new ArrayList<>();
        if(subject.getEstudiantes().size()!=0){
            for(int i = 0; i < subject.getEstudiantes().size(); i++){
                students.add(subject.getEstudiantes().get(i).getIdEstudiante());
            }
        }
        setEstudiantes(students);
    }
}