package com.bosonit.springdata.controller;

import com.bosonit.springdata.application.StudentServiceImpl;
import com.bosonit.springdata.controller.dto.StudentInputDto;
import com.bosonit.springdata.controller.dto.StudentOutputDto;
import com.bosonit.springdata.domain.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/student")
public class Controller {

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent (@RequestBody StudentInputDto student) {
        URI location = URI.create("/student");
        return ResponseEntity.created(location).body(studentService.addStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentOutputDto> getStudentById (@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(studentService.getStudentById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudentById (@RequestParam int id) {
        try {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().body("Student with id: "+id+" was deleted.");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Iterable<StudentOutputDto> getAllStudents (@RequestParam(defaultValue = "0", required = false) int pageNymber,
                                                      @RequestParam(defaultValue = "4", required = false) int pageSize) {
        return studentService.getAlStudents(pageNymber, pageSize);
    }

    @PutMapping
    public ResponseEntity<StudentOutputDto> updateStudent (@RequestBody StudentInputDto student) {
        try {
            studentService.getStudentById(student.getId());
            return ResponseEntity.ok().body(studentService.addStudent(student));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
