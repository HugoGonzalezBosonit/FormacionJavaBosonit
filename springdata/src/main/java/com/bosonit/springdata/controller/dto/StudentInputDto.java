package com.bosonit.springdata.controller.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDto {
    int id;
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    @NotBlank(message = "Nombre Obligatorio")
    String name;
    @Size (min = 3, max = 20, message = "El apellido debe tener entre 3 y 20 caracteres")
    @NotBlank (message = "Apellido obligatorio")
    String lastName;
}
