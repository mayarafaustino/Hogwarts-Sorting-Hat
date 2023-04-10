package br.com.mayara.HogwartsSortingHat.controller;

import br.com.mayara.HogwartsSortingHat.domain.Student;
import br.com.mayara.HogwartsSortingHat.domain.Traits;
import br.com.mayara.HogwartsSortingHat.dto.StudentSaveDTO;
import br.com.mayara.HogwartsSortingHat.dto.StudentTraitsDTO;
import br.com.mayara.HogwartsSortingHat.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("student")
@RestController
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@RequestBody StudentSaveDTO studentDTO) {
        StudentTraitsDTO traitsDTO = new StudentTraitsDTO();
        Traits traits = Traits.builder()
                .courage(traitsDTO.getCourage())
                .wisdom(traitsDTO.getWisdom())
                .ambition(traitsDTO.getAmbition())
                .justice(traitsDTO.getJustice())
                .build();
        Student student = Student.builder()
                .name(studentDTO.getName())
                .birth(studentDTO.getBirth())
                .pet(studentDTO.getPet())
                .build();
        student.setTraits(traits);
        return service.save(student);
    }

    @PutMapping("{id}")
    public Student update(@PathVariable Long id, @RequestBody StudentSaveDTO studentDTO) {
        Student student = Student.builder()
                .name(studentDTO.getName())
                .birth(studentDTO.getBirth())
                .pet(studentDTO.getPet())
                .build();
        return service.update(id, student);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
