package rs.ac.uns.ftn.sbz.projekat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Bolest;

public interface BolestRepository extends JpaRepository<Bolest, Long> {

    Bolest findByNaziv(String naziv);

}
