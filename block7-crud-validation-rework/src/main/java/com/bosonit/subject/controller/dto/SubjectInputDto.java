package com.bosonit.subject.controller.dto;

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
public class SubjectInputDto {
    private String asignatura;
    private String comentarios;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Integer> estudiantes = new ArrayList<>();
}