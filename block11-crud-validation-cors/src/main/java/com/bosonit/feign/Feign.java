package com.bosonit.feign;

import com.bosonit.professor.controller.dto.output.ProfessorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(url = "http://localhost:8081", name = "professorFeign")
public interface Feign {
    @GetMapping("/professor/{id}")
    ResponseEntity<ProfessorOutputDto> callServer(@PathVariable("id") int id);
}
