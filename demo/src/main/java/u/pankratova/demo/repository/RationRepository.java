package u.pankratova.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u.pankratova.demo.model.Ration;

@Repository
public interface RationRepository extends JpaRepository<Ration, Integer> {

    Ration findById(int id);

 /*   int getByCalories();

    int getByWeight();*/
}
