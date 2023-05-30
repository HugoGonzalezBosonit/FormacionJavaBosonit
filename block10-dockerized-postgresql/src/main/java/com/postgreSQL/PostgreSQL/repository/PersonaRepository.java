package com.postgreSQL.PostgreSQL.repository;

import com.postgreSQL.PostgreSQL.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByNombre(String nombre);

    Persona deleteById(int id);
}
