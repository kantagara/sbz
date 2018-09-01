package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Lek;

public interface LekRepository extends JpaRepository<Lek, Long> {

    Lek findByNaziv(String naziv_leka);
}
