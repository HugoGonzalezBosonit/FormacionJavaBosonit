package com.bosonit.professor.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorInputDto {
    private Integer idPersona;
    private String comments;
    private String branch;
}
