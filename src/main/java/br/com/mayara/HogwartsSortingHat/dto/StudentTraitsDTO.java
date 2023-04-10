package br.com.mayara.HogwartsSortingHat.dto;

import lombok.Getter;

import java.util.Random;

@Getter
public class StudentTraitsDTO {

    private final int max = 5;
    private final int min = 1;
    private Integer courage;
    private Integer wisdom;
    private Integer ambition;
    private Integer justice;

    public StudentTraitsDTO() {
        this.courage = new Random().nextInt(min, max + 1);
        this.wisdom = new Random().nextInt(min, max + 1);
        this.ambition = new Random().nextInt(min, max + 1);
        this.justice = new Random().nextInt(min, max + 1);
    }
}
