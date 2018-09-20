package rs.ac.uns.ftn.sbz.projekat.service;

import rs.ac.uns.ftn.sbz.projekat.model.Patient;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.PatientDTO;

import java.util.List;

public interface PatientService {

    Patient save(Patient patient);

    Patient findOne(Long id);

    List<PatientDTO> findAll();

    List<Patient> findAllFromDB();

    void remove(Patient patient);

    Patient findByJmbg(String jmbg);

    boolean create(PatientDTO patientDTO);

    boolean update(PatientDTO patientDTO);
}
