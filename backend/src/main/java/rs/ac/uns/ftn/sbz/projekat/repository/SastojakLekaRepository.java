package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.SastojakLeka;

public interface SastojakLekaRepository extends JpaRepository<SastojakLeka, Long> {

    SastojakLeka findByNaziv(String naziv);
}
