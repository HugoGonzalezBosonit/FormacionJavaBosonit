package com.postgreSQL.PostgreSQL.application;

import com.postgreSQL.PostgreSQL.controller.dto.PersonaInputDto;
import com.postgreSQL.PostgreSQL.controller.dto.PersonaOutputDto;
import com.postgreSQL.PostgreSQL.domain.Persona;
import com.postgreSQL.PostgreSQL.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;
    @Override
    public PersonaOutputDto añadirPersona(PersonaInputDto personaInputDto) {
        return personaRepository.save(new Persona(personaInputDto)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto actualizarPersona(PersonaInputDto personaInputDto) {
        personaRepository.findById(personaInputDto.getId()).orElseThrow();
        return personaRepository.save(new Persona(personaInputDto)).personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto obtenerPersonaPorId(int id) {
        return personaRepository.findById(id).orElseThrow().personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto obtenerPersonaPorNombre(String nombre) {
        return personaRepository.findByNombre(nombre).personaToPersonaOutputDto();
    }

    @Override
    public Iterable<PersonaOutputDto> obtenerPersonas(int numPage, int pageSize) {
        PageRequest pageRequest = PageRequest.of(numPage, pageSize);
        return personaRepository.findAll(pageRequest).getContent().stream().map(Persona::personaToPersonaOutputDto).toList();
    }

    @Override
    public void eliminarPersonaPorId(int id) {
        personaRepository.findById(id).orElseThrow();
        personaRepository.deleteById(id);
    }
}
