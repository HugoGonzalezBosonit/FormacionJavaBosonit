package com.bosonit.professor.aplication;

import com.bosonit.exceptions.EntityNotFoundException;
import com.bosonit.exceptions.UnprocessableEntityException;
import com.bosonit.persona.repository.PersonRepository;
import com.bosonit.professor.controller.dto.input.ProfessorInputDto;
import com.bosonit.professor.controller.dto.output.ProfessorOutputDto;
import com.bosonit.professor.domain.ProfessorEntity;
import com.bosonit.professor.repositoy.ProfessorRepository;
import com.bosonit.student.application.StudentService;
import com.bosonit.student.domain.StudentEntity;
import com.bosonit.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public ProfessorOutputDto añadirProfesor(ProfessorInputDto professorInputDto) throws Exception {
        List<StudentEntity> estudiantes = studentRepository.findAll();
        for (int i = 0; i < estudiantes.size(); i++){
            if(professorInputDto.getIdPersona().equals(estudiantes.get(i).getPerson().getIdPersona())){
                throw new Exception(professorInputDto.getIdPersona()+ " es un estudiante");
            }
        }
        ProfessorEntity professor = professorInputDtoToEntity(professorInputDto);
        professorRepository.save(professor);
        ProfessorOutputDto professorOutputDto = new ProfessorOutputDto(professor);
        return professorOutputDto;
    }
    @Override
    public ProfessorOutputDto obtenerProfesorPorId(Integer id) throws EntityNotFoundException {
        ProfessorEntity professor = professorRepository.findById(id).orElseThrow(EntityNotFoundException::new);//new date
        return new ProfessorOutputDto(professor);
    }
    @Override
    public List<ProfessorOutputDto> obtenerProfesores() {
        List<ProfessorEntity> professor = professorRepository.findAll();
        return professor.stream().map(ProfessorOutputDto::new).toList();
    }
    @Override
    public void borrarProfesor(Integer id) throws Exception {
        professorRepository.delete(professorRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
    private ProfessorEntity professorInputDtoToEntity(ProfessorInputDto profesorInputDto){
        ProfessorEntity professor = new ProfessorEntity();
        professor.setPerson(personRepository.findById(profesorInputDto.getIdPersona()).orElseThrow());
        professor.setComentarios(profesorInputDto.getComments());
        professor.setBranch(profesorInputDto.getBranch());

        return professor;
    }
}
