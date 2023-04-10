package br.com.mayara.HogwartsSortingHat.controller;

import br.com.mayara.HogwartsSortingHat.domain.House;
import br.com.mayara.HogwartsSortingHat.domain.Traits;
import br.com.mayara.HogwartsSortingHat.dto.HouseSaveDTO;
import br.com.mayara.HogwartsSortingHat.service.HouseService;
import br.com.mayara.HogwartsSortingHat.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("house")
@RestController
public class HouseController {

    private final HouseService service;
    private final SchoolService schoolService;

    @GetMapping
    public List<House> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public House getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public House save(@RequestBody HouseSaveDTO houseDTO) {
        Traits traits = Traits.builder()
                .courage(houseDTO.getCourage())
                .wisdom(houseDTO.getWisdom())
                .ambition(houseDTO.getAmbition())
                .justice(houseDTO.getJustice())
                .build();
        House house = House.builder()
                .name(houseDTO.getName())
                .school(schoolService.findById(houseDTO.getSchoolId()))
                .build();
        house.setTraitsPriorities(traits);
        return service.save(house);
    }

    @PutMapping("{id}")
    public House update(@PathVariable Long id, @RequestBody HouseSaveDTO houseDTO) {
        Traits traits = Traits.builder()
                .courage(houseDTO.getCourage())
                .wisdom(houseDTO.getWisdom())
                .ambition(houseDTO.getAmbition())
                .justice(houseDTO.getJustice())
                .build();
        House house = House.builder()
                .name(houseDTO.getName())
                .school(schoolService.findById(houseDTO.getSchoolId()))
                .build();
        house.setTraitsPriorities(traits);
        return service.update(id, house);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
