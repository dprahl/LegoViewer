package prahl.daniel.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import prahl.daniel.model.LegoSet;

import java.util.List;

public interface LegoSetRepository extends CrudRepository<LegoSet, Long> {

    List<LegoSet> findByDescriptionContainsIgnoreCase(String description);

    List<LegoSet> findBySetNumberContains(String setNumber);
}
