package com.bosonit.springdata.repository;

import com.bosonit.springdata.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository<Student, Integer> // El primer parámetro indica el tipo de objeto que se va a mapear y el segundo la clase que se usa como PrimaryKey
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
