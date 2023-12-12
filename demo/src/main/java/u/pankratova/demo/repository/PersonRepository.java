package u.pankratova.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u.pankratova.demo.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

    Person findById(int id);

}
