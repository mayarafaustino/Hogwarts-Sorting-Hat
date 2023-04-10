package br.com.mayara.HogwartsSortingHat.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private LocalDateTime birth;
    @Enumerated(EnumType.STRING)
    private Pets pet;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private Traits traits;
    @ManyToOne(fetch = FetchType.LAZY)
    private House house;

}
