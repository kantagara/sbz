package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent, Long> {

    Pacijent findByJmbg(String jmbg);
}
