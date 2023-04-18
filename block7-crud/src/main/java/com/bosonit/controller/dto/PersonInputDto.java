package com.bosonit.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDto {
   // int id;
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @NotBlank(message = "Nombre Obligatorio")
    String nombre;
    @Size(max = 2, message = "La edad debe ser menor de 100")
    @NotBlank(message = "Edad Obligatoria")
    String edad;
    @Size(min = 2, max = 50, message = "La población debe tener entre 2 y 50 caracteres")
    @NotBlank(message = "Población obligatoria")
    String poblacion;

}
