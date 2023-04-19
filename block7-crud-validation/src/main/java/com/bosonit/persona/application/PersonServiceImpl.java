package com.bosonit.persona.application;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.persona.controller.dto.PersonInputDto;
import com.bosonit.persona.controller.dto.PersonOutputDto;
import com.bosonit.persona.domain.Person;
import com.bosonit.persona.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {
        return personRepository.save(new Person(personInputDto)).personToPersonOutputDto();
    }

    @Override
    public PersonOutputDto findById (int id) throws EntityNotFoundException {
        return personRepository.findById(id).get().personToPersonOutputDto();
    }

    @Override
    public List<Person> findByUsuario(String usuario) {
        return personRepository.findByUsuario(usuario);
    }

    @Override
    public List<Person> findAllOnDataBase() {
        return personRepository.findAll();
    }


}
