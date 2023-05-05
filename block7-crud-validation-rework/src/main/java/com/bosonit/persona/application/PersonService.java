package com.bosonit.persona.application;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.persona.controller.dto.input.PersonInputDto;
import com.bosonit.persona.controller.dto.output.PersonOutputDto;


import java.util.List;

public interface PersonService {
    PersonOutputDto añadirPersona(PersonInputDto personInputDto) throws EntityNotFoundException;
    PersonOutputDto obtenerPersonaPorUsuario(String usuario);
    PersonOutputDto obtenerPersonaPorId(Integer id) throws EntityNotFoundException;
    List<PersonOutputDto> obtenerPersonas();
    void borrarPersona(Integer id) throws Exception;
}
