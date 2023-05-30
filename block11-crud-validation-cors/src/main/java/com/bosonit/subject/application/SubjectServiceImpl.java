package com.bosonit.subject.application;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.student.domain.StudentEntity;
import com.bosonit.student.repository.StudentRepository;
import com.bosonit.subject.controller.dto.SubjectInputDto;
import com.bosonit.subject.controller.dto.SubjectOutputDto;
import com.bosonit.subject.domain.SubjectEntity;
import com.bosonit.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    @Override
    public SubjectOutputDto añadirAsignatura(SubjectInputDto subjectInputDto) throws EntityNotFoundException {
        SubjectEntity subject = subjectInputDtoToEntity(subjectInputDto);
        subjectRepository.save(subject);
        SubjectOutputDto subjectOutputDto = new SubjectOutputDto(subject);
        return subjectOutputDto;
    }
    @Override
    public SubjectOutputDto obtenerAsignaturaPorId(Integer id) throws EntityNotFoundException {
        SubjectEntity subject = subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new SubjectOutputDto(subject);
    }
    @Override
    public List<SubjectOutputDto> obtenerAsignaturas() {
        List<SubjectEntity> subjects = subjectRepository.findAll();
        return subjects.stream().map(SubjectOutputDto::new).toList();
    }
    @Override
    public void borrarAsignatura(Integer id) throws Exception {
        subjectRepository.delete(subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
    @Override
    public void añadirAsignaturaAEstudiante(int idAsignatura, int idEstudiante) {
        StudentEntity student = studentRepository.findById(idEstudiante).orElseThrow();
        SubjectEntity subjecr = subjectRepository.findById(idAsignatura).orElseThrow();
        student.getAsignaturas().add(subjecr);
        studentRepository.save(student);
    }

    private SubjectEntity subjectInputDtoToEntity(SubjectInputDto subjectInputDto){
        SubjectEntity subject = new SubjectEntity();
        List<StudentEntity> students = new ArrayList<>();
        for (int i = 0; i < subjectInputDto.getEstudiantes().size(); i++) {
            students.add(studentRepository.findById(subjectInputDto.getEstudiantes().get(i)).orElseThrow());
        }
        subject.setEstudiantes(students);

        subject.setAsignatura(subjectInputDto.getAsignatura());
        subject.setComentarios(subjectInputDto.getComentarios());
        subject.setFechaInicial(subjectInputDto.getFechaInicial());
        subject.setFechaFinal(subjectInputDto.getFechaFinal());

        return subject;
    }
}