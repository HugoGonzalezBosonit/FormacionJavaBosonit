package com.bosonit.student.controller.dto.output;

import com.bosonit.persona.controller.dto.output.PersonOutputDto;
import com.bosonit.professor.controller.dto.output.ProfessorOutputDto;
import com.bosonit.student.domain.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    private Integer idEstudiante;
    private PersonOutputDto personOutputDto;
    private ProfessorOutputDto professorOutputDto;
    private Integer horasPorSemana;
    private String comentarios;
    private String branch;
    private List<Integer> asignaturas = new ArrayList<>();

    public StudentOutputDto(StudentEntity estudiante){
        setIdEstudiante(estudiante.getIdEstudiante());
        setPersonOutputDto(new PersonOutputDto(estudiante.getPerson()));
        setProfessorOutputDto(new ProfessorOutputDto(estudiante.getProfessor()));
        setHorasPorSemana(estudiante.getHorasPorSemana());
        setComentarios(estudiante.getComentarios());
        setBranch(estudiante.getBranch());

        List<Integer> asignaturas = new ArrayList<>();
        if(estudiante.getAsignaturas() != null) {
            if(estudiante.getAsignaturas().size()!=0){
                for(int i = 0; i < estudiante.getAsignaturas().size(); i++){
                    asignaturas.add(estudiante.getAsignaturas().get(i).getIdAsignatura());
                }
            }
        }
        setAsignaturas(asignaturas);
    }
}