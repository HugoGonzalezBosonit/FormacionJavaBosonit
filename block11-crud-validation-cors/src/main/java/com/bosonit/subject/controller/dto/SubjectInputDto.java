package com.bosonit.subject.controller.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectInputDto {
    private String asignatura;
    private String comentarios;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Integer> estudiantes = new ArrayList<>();
}