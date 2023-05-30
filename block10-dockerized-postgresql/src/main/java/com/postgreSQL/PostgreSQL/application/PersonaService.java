package com.postgreSQL.PostgreSQL.application;


import com.postgreSQL.PostgreSQL.controller.dto.PersonaInputDto;
import com.postgreSQL.PostgreSQL.controller.dto.PersonaOutputDto;

public interface PersonaService {
    PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto);
    PersonaOutputDto actualizarPersona(PersonaInputDto personaInputDto);
    PersonaOutputDto obtenerPersonaPorId(int id);
    PersonaOutputDto obtenerPersonaPorNombre(String nombre);
    Iterable<PersonaOutputDto> obtenerPersonas(int numPage, int pageSize);
    void eliminarPersonaPorId(int id);
}
