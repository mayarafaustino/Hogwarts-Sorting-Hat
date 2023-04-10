package br.com.mayara.HogwartsSortingHat.controller;

import br.com.mayara.HogwartsSortingHat.domain.School;
import br.com.mayara.HogwartsSortingHat.dto.SchoolSaveDTO;
import br.com.mayara.HogwartsSortingHat.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("school")
@RestController
public class SchoolController {

    private final SchoolService service;

    @GetMapping
    public List<School> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public School getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public School save(@RequestBody SchoolSaveDTO schoolDTO) {
        School school = School.builder()
                .name(schoolDTO.getName())
                .build();
        return service.save(school);
    }

    @PutMapping("{id}")
    public School update(@PathVariable Long id, @RequestBody SchoolSaveDTO schoolDTO) {
        School school = School.builder()
                .name(schoolDTO.getName())
                .build();
        return service.update(id, school);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
