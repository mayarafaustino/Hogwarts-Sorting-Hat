package br.com.mayara.HogwartsSortingHat.dto;

import br.com.mayara.HogwartsSortingHat.domain.Pets;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class StudentSaveDTO {

    private String name;
    private LocalDateTime birth;
    private Pets pet;
}
