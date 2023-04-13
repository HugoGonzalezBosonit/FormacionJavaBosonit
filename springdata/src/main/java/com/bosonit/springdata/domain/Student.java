package com.bosonit.springdata.domain;

import com.bosonit.springdata.controller.dto.StudentInputDto;
import com.bosonit.springdata.controller.dto.StudentOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Spring creará una tabla con el nombre de esta class. Los atributos junto con sus nombres serán las columnas de la tabla
@Data // Librería de lombok que genera Setters / Getters / toString / Equals / hashCode
@NoArgsConstructor // Librería de lomook que genera un constructor sin argumentos
@AllArgsConstructor // Librería de lombok que genera un constructor con todos los argumentos de la class
public class Student {
    @Id // Indicará que se trata de un campo que va a ser PrimaryKey en nuestra base de datos
    @GeneratedValue // Spring en caso de no indicar la Id nos va a generar una automáticamente (Por defecto int 1 --> 2 --> 3...)
    int id;
    String name;
    String lastName;

    public Student (StudentInputDto studentInputDto) {
        this.id = studentInputDto.getId();
        this.name = studentInputDto.getName();
        this.lastName = studentInputDto.getLastName();
    }

    public StudentOutputDto studentToStudentOutputDto() {
        return new StudentOutputDto(
                this.id,
                this.name,
                this.lastName);
    }
}
