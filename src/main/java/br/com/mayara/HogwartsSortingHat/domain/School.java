package br.com.mayara.HogwartsSortingHat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class School {

    private Long id;
    private String name;
    private Professor headMaster;
    private List<House> houses;
}
