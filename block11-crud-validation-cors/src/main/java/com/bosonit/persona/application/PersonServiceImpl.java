package com.bosonit.persona.application;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.persona.controller.dto.input.PersonInputDto;
import com.bosonit.persona.controller.dto.output.PersonOutputDto;
import com.bosonit.persona.domain.PersonEntity;
import com.bosonit.persona.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public PersonOutputDto añadirPersona(PersonInputDto personInputDto) throws EntityNotFoundException {
        if (personRepository.findByUsuario(personInputDto.getUsuario()) == null) {
            PersonEntity persona = personInputDtoToEntity(personInputDto);
            personRepository.save(persona);
            return new PersonOutputDto(persona);
        } else {
            throw new EntityNotFoundException();
        }
    }
    @Override
    public PersonOutputDto obtenerPersonaPorUsuario(String usuario) {
        PersonEntity persona = personRepository.findByUsuario(usuario);
        return new PersonOutputDto(persona);
    }
    @Override
    public PersonOutputDto obtenerPersonaPorId(Integer id) throws EntityNotFoundException {
        PersonEntity persona = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return new PersonOutputDto(persona);
    }
    @Override
    public List<PersonOutputDto> obtenerPersonas() {
        List<PersonEntity> personEntities = personRepository.findAll();
        return personEntities.stream().map(PersonOutputDto::new).toList();
    }
    @Override
    public void borrarPersona(Integer id) throws Exception {
        personRepository.delete(personRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
    public PersonEntity personInputDtoToEntity(PersonInputDto personaInputDto) {
        PersonEntity persona = new PersonEntity();
        persona.setUsuario(personaInputDto.getUsuario());
        persona.setContraseña(personaInputDto.getContraseña());
        persona.setNombre(personaInputDto.getNombre());
        persona.setApellido(personaInputDto.getApellido());
        persona.setEmailCompañia(personaInputDto.getEmailCompañia());
        persona.setEmailPersonal(personaInputDto.getEmailCompañia());
        persona.setCity(personaInputDto.getCity());
        persona.setActivo(personaInputDto.isActivo());
        persona.setFechaCreacion(personaInputDto.getFechaCreacion());
        persona.setImageUrl(personaInputDto.getUrlImagen());
        persona.setFechaFinalizacion(personaInputDto.getFechaFinalizacion());

        return persona;
    }
}
