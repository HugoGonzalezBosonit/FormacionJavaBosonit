package com.bosonit.springdata.application;

import com.bosonit.springdata.controller.dto.StudentInputDto;
import com.bosonit.springdata.controller.dto.StudentOutputDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    StudentOutputDto addStudent (StudentInputDto student);
    StudentOutputDto getStudentById (int id);
    void deleteStudentById (int id);
    List<StudentOutputDto> getAlStudents(int pageNumber, int pageSize);

    StudentOutputDto updateStudent (StudentInputDto student);
}
