package com.bosonit.subject.repository;

import com.bosonit.subject.domain.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {
}