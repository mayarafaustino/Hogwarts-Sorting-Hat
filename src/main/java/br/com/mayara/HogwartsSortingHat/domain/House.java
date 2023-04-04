package br.com.mayara.HogwartsSortingHat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private Long id;
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private Professor head;
    private Traits traitsPriorities;
}
