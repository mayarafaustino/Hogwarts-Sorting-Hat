package br.com.mayara.HogwartsSortingHat.service;

import br.com.mayara.HogwartsSortingHat.domain.House;
import br.com.mayara.HogwartsSortingHat.domain.Student;

import java.util.List;

public interface HouseService {

    List<House> list();

    House findById(Long id);

    House save(House house);

    House update(Long id, House house);

    void delete(Long id);
}
