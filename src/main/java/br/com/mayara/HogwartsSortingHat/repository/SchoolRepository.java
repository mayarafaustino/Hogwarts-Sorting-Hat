package br.com.mayara.HogwartsSortingHat.repository;

import br.com.mayara.HogwartsSortingHat.domain.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {

}
