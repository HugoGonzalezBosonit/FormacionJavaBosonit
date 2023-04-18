package com.bosonit.repository;

import com.bosonit.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByNombre(String nombre);

}
