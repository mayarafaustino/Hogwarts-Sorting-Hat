package br.com.mayara.HogwartsSortingHat.service;

import br.com.mayara.HogwartsSortingHat.domain.Student;
import br.com.mayara.HogwartsSortingHat.exception.StudentNotFoundException;
import br.com.mayara.HogwartsSortingHat.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;

    @Override
    public List<Student> list() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return repository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException();
        }
        student.setId(id);
        return repository.save(student);

    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException();
        }
        repository.deleteById(id);
    }
}
