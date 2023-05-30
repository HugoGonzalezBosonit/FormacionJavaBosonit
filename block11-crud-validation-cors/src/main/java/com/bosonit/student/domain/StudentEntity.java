package com.bosonit.student.domain;

import com.bosonit.persona.domain.PersonEntity;
import com.bosonit.professor.domain.ProfessorEntity;
import com.bosonit.student.controller.dto.input.StudentInputDto;
import com.bosonit.student.controller.dto.output.StudentOutputDto;
import com.bosonit.subject.domain.SubjectEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_student")
    private Integer idEstudiante;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_persona")
    private PersonEntity person;
    @Column(name = "num_houtr_week")
    private Integer horasPorSemana;
    @Column(name = "coments")
    private String comentarios;
    @Column(name = "branch")
    private String branch;
    @ManyToMany
    List<SubjectEntity> asignaturas= new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_profesor")
    private ProfessorEntity professor;

}