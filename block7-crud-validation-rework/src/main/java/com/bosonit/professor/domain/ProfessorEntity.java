package com.bosonit.professor.domain;

import com.bosonit.persona.domain.PersonEntity;
import com.bosonit.professor.controller.dto.input.ProfessorInputDto;
import com.bosonit.professor.controller.dto.output.ProfessorOutputDto;
import com.bosonit.student.domain.StudentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Profesor")
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_professor")
    private Integer idProfesor;
    @OneToOne(cascade = {CascadeType.ALL}) // CHECKED
    @JoinColumn(name = "fk_persona", unique = true)
    private PersonEntity person;
    private String comentarios;
    private String branch;
    @OneToMany(mappedBy = "professor")
    private List<StudentEntity> estudiantes;


}
