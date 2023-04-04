package br.com.mayara.HogwartsSortingHat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private ZonedDateTime birth;
    private House house;
}
