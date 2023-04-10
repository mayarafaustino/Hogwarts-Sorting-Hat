package br.com.mayara.HogwartsSortingHat.service;

import br.com.mayara.HogwartsSortingHat.domain.House;
import br.com.mayara.HogwartsSortingHat.domain.School;
import br.com.mayara.HogwartsSortingHat.domain.Student;

import java.util.List;

public interface SchoolService {

    List<School> list();

    School findById(Long id);

    School save(School school);

    School update(Long id, School school);

    void delete(Long id);

}
