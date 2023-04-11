package br.com.mayara.HogwartsSortingHat.service;

import br.com.mayara.HogwartsSortingHat.domain.Student;
import br.com.mayara.HogwartsSortingHat.exception.StudentNotFoundException;
import br.com.mayara.HogwartsSortingHat.repository.HouseRepository;
import br.com.mayara.HogwartsSortingHat.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;
    private final HouseService houseService;
    private final HouseRepository houseRepository;

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
        //sorting(student)
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

//    public House sorting(Student student) {
//        List<House> possibleHouses = houseService.list().stream()
//                .filter(house -> house.getTraitsPriorities().getCourage() <= student.getTraits().getCourage())
//                .filter(house -> house.getTraitsPriorities().getAmbition() <= student.getTraits().getAmbition())
//                .filter(house -> house.getTraitsPriorities().getWisdom() <= student.getTraits().getWisdom())
//                .filter(house -> house.getTraitsPriorities().getJustice() <= student.getTraits().getJustice())
//                .toList();
//        if (possibleHouses.size() == 0) {
//            //return houseRepository.findHouseByName("Huffleppuff");
//        }
//        if (possibleHouses.size() == 1) {
//            //return possibleHouses.get(0);
//        }
//        if (possibleHouses.size() > 1) {
//
//        }
//    }
}
