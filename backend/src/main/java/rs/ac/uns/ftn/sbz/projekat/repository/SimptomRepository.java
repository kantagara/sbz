package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Simptom;


public interface SimptomRepository extends JpaRepository<Simptom, Long> {

    Simptom findByNaziv(String naziv);

}
