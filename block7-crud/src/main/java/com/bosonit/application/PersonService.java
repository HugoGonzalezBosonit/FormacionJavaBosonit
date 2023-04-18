package com.bosonit.application;

import com.bosonit.controller.dto.PersonInputDto;
import com.bosonit.controller.dto.PersonOutputDto;
import com.bosonit.domain.Person;

import java.util.List;

public interface PersonService {
    PersonOutputDto addPerson (PersonInputDto personInputDto);
    PersonOutputDto consultPersonById (int id);
    List<Person> consultPersonByName (String nombre);
    List<PersonOutputDto> consultAllPeople (int pageNumber, int pageSize);
    void deletePersonById (int id);
    PersonOutputDto modPersonById (int id, PersonInputDto personInputDto);

}
