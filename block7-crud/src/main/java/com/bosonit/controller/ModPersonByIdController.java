package com.bosonit.controller;

import com.bosonit.application.PersonServiceImpl;
import com.bosonit.controller.dto.PersonInputDto;
import com.bosonit.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
public class ModPersonByIdController {

    @Autowired
    PersonServiceImpl personService;

    @PutMapping("/{id}")
    public PersonOutputDto modPersonById (@PathVariable int id, @RequestBody PersonInputDto personInputDto) throws Exception{
        return personService.modPersonById(id, personInputDto);
    }

   // @PutMapping("/{id}")
   // public ResponseEntity<PersonOutputDto> modPersonById (@PathVariable int id, @RequestBody PersonInputDto personInputDto) {
   //     try {
   //         personService.modPersonById(personInputDto.getId());
   //         return ResponseEntity.ok().body(personService.addPerson(personInputDto));
   //     } catch (Exception e) {
   //         return ResponseEntity.notFound().build();
   //     }
   // }

}
