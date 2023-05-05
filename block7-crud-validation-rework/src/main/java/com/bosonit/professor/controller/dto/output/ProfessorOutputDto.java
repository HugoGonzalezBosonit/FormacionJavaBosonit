package com.bosonit.professor.controller.dto.output;

import com.bosonit.persona.controller.dto.output.PersonOutputDto;
import com.bosonit.professor.domain.ProfessorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorOutputDto {
    private Integer idProfesor;
    private PersonOutputDto personOutputDto;
    private String comments;
    private String branch;

    public ProfessorOutputDto(ProfessorEntity profesor){
        setIdProfesor(profesor.getIdProfesor());
        setPersonOutputDto(new PersonOutputDto(profesor.getPerson()));
        setComments(profesor.getComentarios());
        setBranch(profesor.getBranch());
    }
}
