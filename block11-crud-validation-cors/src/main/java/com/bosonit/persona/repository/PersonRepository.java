package com.bosonit.persona.repository;


import com.bosonit.persona.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    PersonEntity findByUsuario(String usuario);
}
