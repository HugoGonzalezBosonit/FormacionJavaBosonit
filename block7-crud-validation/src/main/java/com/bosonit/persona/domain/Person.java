package com.bosonit.persona.domain;

import com.bosonit.persona.controller.dto.PersonInputDto;
import com.bosonit.persona.controller.dto.PersonOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id", nullable = false)
    private int personId;
    @Column(name = "usuario", nullable = false, length = 10)
    private String usuario;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "name", nullable = true)
    private String name;
    @Column(name = "surname", nullable = true)
    private String surname;
    @Column(name = "company_email", nullable = false)
    private String companyEmail;
    @Column(name = "personal_email", nullable = false)
    private String personalEmail;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "active", nullable = false)
    private boolean active;
    @Column(name = "created_date") //Necesita revision
    private Date createdDate = new Date();
    @Column(name = "image_url", nullable = true)
    private String imageUrl;
    @Column(name = "termination_date", nullable = true)
    private Date terminationDate;

    public Person (PersonInputDto personInputDto) {
        this.usuario = personInputDto.getUsuario();
        this.password = personInputDto.getPassword();
        this.name = personInputDto.getName();
        this.surname = personInputDto.getSurname();
        this.companyEmail = personInputDto.getCompanyEmail();
        this.personalEmail = personInputDto.getPersonalEmail();
        this.city = personInputDto.getCity();
        this.active = personInputDto.isActive();
        this.imageUrl = personInputDto.getImageUrl();
        this.terminationDate = personInputDto.getTerminationDate();
    }

    public PersonOutputDto personToPersonOutputDto() {
        return new PersonOutputDto(
                this.personId,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.companyEmail,
                this.personalEmail,
                this.city,
                this.active,
                this.createdDate,
                this.imageUrl,
                this.terminationDate);
    }

}
