package com.bosonit.persona.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDto {
    @Size(min = 6, max = 10, message = "El usuario debe tener entre 6 y 10 caracteres")
    @NotNull(message = "Usuario obligatorio")
    private String usuario;
    @NotNull(message = "Contraseña obligatorio")
    private String password;
    private String name;
    private String surname;
    @NotNull(message = "Email de la compañía obligatorio")
    private String companyEmail;
    @NotNull(message = "Email personal obligatorio")
    private String personalEmail;
    @NotNull(message = "Ciudad obligatoria")
    private String city;
    @NotNull(message = "Actividad obligatoria")
    private boolean active;
    @NotNull(message = "Fecha actual obligatoria")
    String imageUrl;
    Date terminationDate;

}
