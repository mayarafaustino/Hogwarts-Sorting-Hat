package br.com.mayara.HogwartsSortingHat.service;

import br.com.mayara.HogwartsSortingHat.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> list();

    Student findById(Long id);

    Student save(Student student);

    Student update(Long id, Student student);

    void delete(Long id);
}
