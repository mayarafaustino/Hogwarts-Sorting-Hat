package br.com.mayara.HogwartsSortingHat.dto;

import br.com.mayara.HogwartsSortingHat.domain.School;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseSaveDTO {

    private String name;
    private Long schoolId;
    private Integer courage;
    private Integer wisdom;
    private Integer ambition;
    private Integer justice;
}
