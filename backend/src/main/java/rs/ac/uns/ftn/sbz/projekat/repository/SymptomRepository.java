package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs.ac.uns.ftn.sbz.projekat.model.Symptom;


public interface SymptomRepository extends JpaRepository<Symptom, Long> {

    Symptom findByName(String name);

    Symptom findByNameAndValueGreaterThanEqual(String name, Double value);
    Symptom findByNameAndValue(String name, Double value);
}
