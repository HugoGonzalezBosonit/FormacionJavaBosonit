package com.bosonit.student.controller.dto.input;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDto {
    private Integer idPersona;
    private Integer idProfesor;
    private Integer horasPorSemana;
    private String comentarios;
    private String branch;
    private List <Integer> asignaturas = new ArrayList<>();

}