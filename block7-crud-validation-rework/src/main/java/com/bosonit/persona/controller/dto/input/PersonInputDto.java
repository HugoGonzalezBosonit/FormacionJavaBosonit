package com.bosonit.persona.controller.dto.input;

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
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String emailCompañia;
    private String emailPersonal;
    private String city;
    private boolean activo;
    private Date fechaCreacion;
    private String urlImagen;
    private Date fechaFinalizacion;

}
