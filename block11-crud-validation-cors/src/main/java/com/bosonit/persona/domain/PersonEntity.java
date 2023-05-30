package com.bosonit.persona.domain;

import com.bosonit.professor.domain.ProfessorEntity;
import com.bosonit.student.domain.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person", nullable = false)
    private Integer idPersona;

    @Column(name = "usuario", nullable = false, length = 10)
    private String usuario;

    @Column(name = "password", nullable = false)
    private String contraseña;

    @Column(name = "name", nullable = false)
    private String nombre;

    @Column(name = "surname")
    private String apellido;

    @Column(name = "campany_email", nullable = false)
    private String emailCompañia;

    @Column(name = "personal_email", nullable = false)
    private String emailPersonal;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "active", nullable = false)
    private boolean activo;

    @Column(name = "creation_date", nullable = false)
    private Date fechaCreacion;

    @Column(name = "url_imagen")
    private String ImageUrl;

    @Column(name = "termination_date")
    private Date fechaFinalizacion;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY) // CHECKED // Una persona tiene asignado un estudiante (o profesor) CHECKED
    private StudentEntity estudiante;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private ProfessorEntity profesor;

}
