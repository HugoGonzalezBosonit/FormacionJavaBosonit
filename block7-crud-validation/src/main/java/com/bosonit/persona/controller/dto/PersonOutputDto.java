package com.bosonit.persona.controller.dto;

import com.bosonit.persona.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonOutputDto {
    private Integer personId;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;

    //public PersonaOutputDto(Person person){
    //    setPersonId(person.getPersonId());
    //    setUsuario(person.getUsuario());
    //    setName(person.getName());
    //    setSurname(person.getSurname());
    //    setCompanyEmail(person.getCompanyEmail());
    //    setPersonalEmail(person.getPersonalEmail());
    //    setCity(person.getCity());
    //    setActive(person.isActive());
    //    setCreatedDate(person.getCreatedDate());
    //    setImageUrl(person.getImageUrl());
    //    setTerminationDate(person.getTerminationDate());
    //}

}
