package com.bosonit.springdata.controller.dto;


import com.bosonit.springdata.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    int id;
    String name;
    String lastName;

    public StudentOutputDto(Student student){
        setId(student.getId());
        setName(student.getName());
        setLastName(student.getLastName());
    }
}
