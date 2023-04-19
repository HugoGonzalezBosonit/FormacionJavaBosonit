package com.bosonit.persona.repository;


import com.bosonit.persona.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends
        JpaRepository<Person, Integer> {
    List<Person> findByUsuario(String usuario);

}
