package br.com.mayara.HogwartsSortingHat.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "house")
    private List<Student> students;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private Traits traitsPriorities;

    @ManyToOne
    @JsonIgnoreProperties("houses")
    private School school;

    //private List<Professor> professors;
    //private Professor head;
}
