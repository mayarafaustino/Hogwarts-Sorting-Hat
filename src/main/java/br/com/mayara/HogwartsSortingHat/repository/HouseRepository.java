package br.com.mayara.HogwartsSortingHat.repository;

import br.com.mayara.HogwartsSortingHat.domain.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

    House findHouseByName(String name);
}
