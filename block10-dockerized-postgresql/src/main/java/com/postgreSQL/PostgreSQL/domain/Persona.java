package com.postgreSQL.PostgreSQL.domain;

import com.postgreSQL.PostgreSQL.controller.dto.PersonaInputDto;
import com.postgreSQL.PostgreSQL.controller.dto.PersonaOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    int id;
    String nombre;
    String poblacion;
    int edad;

    public Persona(PersonaInputDto personInputDto) {
        this.id = personInputDto.getId();
        this.nombre = personInputDto.getNombre();
        this.poblacion = personInputDto.getPoblacion();
        this.edad = personInputDto.getEdad();
    }

    public PersonaOutputDto personaToPersonaOutputDto() {
        return new PersonaOutputDto (
                this.id,
                this.nombre,
                this.poblacion,
                this.edad
        );
    }
}
