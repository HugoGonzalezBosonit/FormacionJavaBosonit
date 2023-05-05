package com.bosonit.student.controller.dto.output;

import com.bosonit.student.domain.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSimpleOutputDto {
    private Integer idEstudiante;
    private Integer idPersona;
    private Integer horasPorSemana;
    private String comentarios;
    private String branch;
    private List<Integer> asignaturas = new ArrayList<>();
    public StudentSimpleOutputDto(StudentEntity estudiante){
        setIdEstudiante(estudiante.getIdEstudiante());
        setIdPersona(estudiante.getPerson().getIdPersona());
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
