package rs.ac.uns.ftn.sbz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sbz.projekat.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByJmbg(String jmbg);
}
