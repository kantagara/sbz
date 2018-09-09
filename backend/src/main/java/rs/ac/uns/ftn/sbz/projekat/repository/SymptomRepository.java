package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Symptom;


public interface SymptomRepository extends JpaRepository<Symptom, Long> {

    Symptom findByName(String name);
}
