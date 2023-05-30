package com.bosonit.student.application;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.persona.repository.PersonRepository;
import com.bosonit.professor.domain.ProfessorEntity;
import com.bosonit.professor.repositoy.ProfessorRepository;
import com.bosonit.student.controller.dto.input.StudentInputDto;
import com.bosonit.student.controller.dto.output.StudentFullOutputDto;
import com.bosonit.student.controller.dto.output.StudentOutputDto;
import com.bosonit.student.controller.dto.output.StudentSimpleOutputDto;
import com.bosonit.student.domain.StudentEntity;
import com.bosonit.student.repository.StudentRepository;
import com.bosonit.subject.domain.SubjectEntity;
import com.bosonit.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public StudentOutputDto añadirEstudiante(StudentInputDto studentInputDto) throws Exception {
        List<ProfessorEntity> profesores = professorRepository.findAll();
        for (int i = 0; i < profesores.size(); i++){
            if(studentInputDto.getIdPersona().equals(profesores.get(i).getPerson().getIdPersona())){
                throw new Exception(studentInputDto.getIdPersona()+ " ya es un estudiante");
            }
        }
        StudentEntity student = studentInputDtoToEntity(studentInputDto);
        studentRepository.save(student);
        StudentOutputDto studentOutputDto = new StudentOutputDto(student);
        return studentOutputDto;
    }

    @Override
    public StudentSimpleOutputDto obtenerEstudianteSimplePorId(Integer id, String outputType) throws EntityNotFoundException {
        StudentEntity student = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        StudentSimpleOutputDto studentSimpleOutputDto = new StudentSimpleOutputDto(student);
        return studentSimpleOutputDto;
    }

    @Override
    public StudentFullOutputDto obtenerEstudianteFullPorId(Integer id, String outputType) throws EntityNotFoundException {
        StudentEntity student = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        StudentFullOutputDto studentFullOutputDto  = new StudentFullOutputDto(student);
        return studentFullOutputDto;
    }

    @Override
    public List<StudentOutputDto> obtenerEstudiantes() {
        List<StudentEntity> students = studentRepository.findAll();
        return students.stream().map(StudentOutputDto::new).toList();
    }


    @Override
    public void borrarEstudiante(Integer id) throws Exception {
        studentRepository.delete(studentRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
    private StudentEntity studentInputDtoToEntity(StudentInputDto studentInputDto){
        StudentEntity student = new StudentEntity();

        student.setPerson(personRepository.findById(studentInputDto.getIdPersona()).orElseThrow());
        student.setProfessor(professorRepository.findById(studentInputDto.getIdProfesor()).orElseThrow());
        student.setHorasPorSemana(studentInputDto.getHorasPorSemana());
        student.setComentarios(studentInputDto.getComentarios());
        student.setBranch(studentInputDto.getBranch());
        if (studentInputDto.getAsignaturas()!=null)
        {
            List<SubjectEntity> subjects=new ArrayList<>();
            for (int asignatura: studentInputDto.getAsignaturas())
            {
                SubjectEntity asignatura1= subjectRepository.findById(asignatura).orElseThrow();
                subjects.add(asignatura1);
            }
            student.setAsignaturas(subjects);
        }
        return student;
    }
}
