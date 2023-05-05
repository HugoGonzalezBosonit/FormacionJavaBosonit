package com.bosonit.persona.controller.dto.output;

import com.bosonit.persona.domain.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {
    private Integer idPersona;
    private String usuario;
    private String nombre;
    private String apellido;
    private String emailCompañia;
    private String emailPersonal;
    private String city;
    private boolean activo;
    private Date fechaCreacion;
    private String urlImagen;
    private Date fechaFinalizacion;

    public PersonOutputDto(PersonEntity persona){
        setIdPersona(persona.getIdPersona());
        setUsuario(persona.getUsuario());
        setNombre(persona.getNombre());
        setApellido(persona.getApellido());
        setEmailCompañia(persona.getEmailCompañia());
        setEmailPersonal(persona.getEmailCompañia());
        setCity(persona.getCity());
        setActivo(persona.isActivo());
        setFechaCreacion(persona.getFechaCreacion());
        setUrlImagen(persona.getImageUrl());
        setFechaFinalizacion(persona.getFechaFinalizacion());
    }
}
