package com.bosonit.application;


import com.bosonit.controller.dto.PersonInputDto;
import com.bosonit.controller.dto.PersonOutputDto;
import com.bosonit.domain.Person;
import com.bosonit.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDto addPerson(PersonInputDto personInputDto) {
        return personRepository.save(new Person(personInputDto)).personToPersonOutputDto();
    }

    @Override
    public PersonOutputDto consultPersonById(int id) {
        return personRepository.findById(id).orElseThrow().personToPersonOutputDto();
    }

    @Override
    public List<Person> consultPersonByName(String nombre) {
        //return personRepository.findByNombre(nombre).personToPersonOutputDto();
        return personRepository.findByNombre(nombre);
    }

    @Override
    public List<PersonOutputDto> consultAllPeople (int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return personRepository.findAll(pageRequest).getContent().stream().map(PersonOutputDto::new).toList();
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }

    @Override
    public PersonOutputDto modPersonById(int id, PersonInputDto personInputDto) {
        Person person = personRepository.findById(id).orElseThrow();

        person.setNombre(personInputDto.getNombre());
        person.setEdad(personInputDto.getEdad());
        person.setPoblacion(personInputDto.getPoblacion());

        personRepository.save(person);
        return new PersonOutputDto(person);
    }

    //@Override
 //public PersonOutputDto modPersonById(PersonInputDto personInputDto) {
 //    personRepository.findById(personInputDto.getId()).orElseThrow();
 //    return personRepository.save(new Person(personInputDto)).personToPersonOutputDto();
 //}
}
