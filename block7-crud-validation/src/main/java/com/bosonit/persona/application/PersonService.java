package com.bosonit.persona.application;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.persona.controller.dto.PersonInputDto;
import com.bosonit.persona.controller.dto.PersonOutputDto;
import com.bosonit.persona.domain.Person;

import java.util.List;

public interface PersonService {

    // Agrego un añadir persona para añadirlas desde Postman y no tener que hacerlo a mano en la base de datos
    PersonOutputDto addPerson (PersonInputDto personInputDto);
    PersonOutputDto findById (int id) throws EntityNotFoundException;
    List<Person> findByUsuario (String usuario);
    List<Person> findAllOnDataBase ();

}
