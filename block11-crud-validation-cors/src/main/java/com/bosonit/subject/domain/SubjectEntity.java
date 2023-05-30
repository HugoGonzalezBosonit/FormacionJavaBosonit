package com.bosonit.subject.domain;

import com.bosonit.student.domain.StudentEntity;
import com.bosonit.subject.controller.dto.SubjectInputDto;
import com.bosonit.subject.controller.dto.SubjectOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Subjects")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_subject")
    private Integer idAsignatura;
    @Column(name = "subject")
    private String asignatura;
    @Column(name = "coments")
    private String comentarios;
    @Column(name = "start_up_date")
    private Date fechaInicial;
    @Column(name = "final_date")
    private Date fechaFinal;
    @ManyToMany(mappedBy = "asignaturas")
    List<StudentEntity> estudiantes = new ArrayList<>();
}
