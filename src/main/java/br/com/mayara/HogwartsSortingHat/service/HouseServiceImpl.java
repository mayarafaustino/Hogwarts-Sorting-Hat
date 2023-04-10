package br.com.mayara.HogwartsSortingHat.service;

import br.com.mayara.HogwartsSortingHat.domain.House;
import br.com.mayara.HogwartsSortingHat.exception.HouseNotFoundException;
import br.com.mayara.HogwartsSortingHat.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService{

    private final HouseRepository repository;

    @Override
    public List<House> list() {
        return (List<House>) repository.findAll();
    }

    @Override
    public House findById(Long id) {
        return repository.findById(id).orElseThrow(HouseNotFoundException::new);
    }

    @Override
    public House save(House house) {
        return repository.save(house);
    }

    @Override
    public House update(Long id, House house) {
        if (!repository.existsById(id)) {
            throw new HouseNotFoundException();
        }
        house.setId(id);
        return repository.save(house);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new HouseNotFoundException();
        }
        repository.deleteById(id);
    }
}
