package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;

import java.util.List;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
