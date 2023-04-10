package br.com.mayara.HogwartsSortingHat.service;

import br.com.mayara.HogwartsSortingHat.domain.School;
import br.com.mayara.HogwartsSortingHat.exception.HouseNotFoundException;
import br.com.mayara.HogwartsSortingHat.exception.SchoolNotFoundException;
import br.com.mayara.HogwartsSortingHat.exception.StudentNotFoundException;
import br.com.mayara.HogwartsSortingHat.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService{

    private final SchoolRepository repository;

    @Override
    public List<School> list() {
        return (List<School>) repository.findAll();
    }

    @Override
    public School findById(Long id) {
        return repository.findById(id).orElseThrow(SchoolNotFoundException::new);
    }

    @Override
    public School save(School school) {
        //só salvar um
        return repository.save(school);
    }

    @Override
    public School update(Long id, School school) {
        if (!repository.existsById(id)) {
            throw new HouseNotFoundException();
        }
        school.setId(id);
        return repository.save(school);
    }

    @Override
    public void delete(Long id) {
        //nao pode deletar se tiver apenas uma escola?
        if (!repository.existsById(id)) {
            throw new SchoolNotFoundException();
        }
        repository.deleteById(id);
    }
}
