package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Remedy;

public interface RemedyRepository extends JpaRepository<Remedy, Long> {

    Remedy findByName(String name);
}
