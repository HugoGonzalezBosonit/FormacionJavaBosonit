package com.bosonit.springdata.application;

import com.bosonit.springdata.controller.dto.StudentInputDto;
import com.bosonit.springdata.controller.dto.StudentOutputDto;
import com.bosonit.springdata.domain.Student;
import com.bosonit.springdata.repository.StudentRepository;
import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentOutputDto addStudent (StudentInputDto student) {
    //    return studentRepository.save (new Student(student)).studentToStudentOutputDto();
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setLastName(student.getLastName());

        studentRepository.save(student1);
        return new StudentOutputDto(student1);
    }

    @Override
    public StudentOutputDto getStudentById (int id) {
        return studentRepository.findById(id).orElseThrow().studentToStudentOutputDto();
    }

    @Override
    public void deleteStudentById (int id) {
        studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
    }
    @Override
    public List<StudentOutputDto> getAlStudents(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageRequest).getContent().stream().map(StudentOutputDto::new).toList();
    }

    @Override
    public StudentOutputDto updateStudent (StudentInputDto student) {
        studentRepository.findById(student.getId()).orElseThrow();
        return studentRepository.save(new Student(student)).studentToStudentOutputDto();
    }
}

