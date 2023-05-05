package com.bosonit.student.controller.dto.output;

import com.bosonit.persona.controller.dto.output.PersonOutputDto;
import com.bosonit.student.domain.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFullOutputDto extends StudentSimpleOutputDto {
    private PersonOutputDto personOutputDto;

    public StudentFullOutputDto(StudentEntity studentEntity) {
        super(studentEntity);
        setPersonOutputDto(new PersonOutputDto(studentEntity.getPerson()));
    }
}
