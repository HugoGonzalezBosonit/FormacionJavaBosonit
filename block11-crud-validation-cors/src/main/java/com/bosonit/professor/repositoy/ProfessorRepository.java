package com.bosonit.professor.repositoy;

import com.bosonit.professor.domain.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {

}
