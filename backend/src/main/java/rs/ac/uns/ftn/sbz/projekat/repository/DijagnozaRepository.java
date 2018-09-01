package rs.ac.uns.ftn.sbz.projekat.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Dijagnoza;

import java.util.List;

public interface DijagnozaRepository extends JpaRepository<Dijagnoza, Long> {

    Dijagnoza save(Dijagnoza log);

    Dijagnoza findOne(Long id);

    List<Dijagnoza> findAll();
}
