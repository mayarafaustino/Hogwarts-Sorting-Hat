package br.com.mayara.HogwartsSortingHat.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Traits {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer courage;
    private Integer wisdom;
    private Integer ambition;
    private Integer justice;
}
