package rs.ac.uns.ftn.sbz.projekat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Disease findByName(String name);

}
