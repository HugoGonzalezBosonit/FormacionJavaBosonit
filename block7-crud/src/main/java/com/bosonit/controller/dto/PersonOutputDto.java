package com.bosonit.controller.dto;

import com.bosonit.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {
    int id;
    String nombre;
    String edad;
    String poblacion;

    public PersonOutputDto(Person person) {
        setId(person.getId());
        setNombre(person.getNombre());
        setEdad(person.getEdad());
        setPoblacion(person.getPoblacion());
    }
}
