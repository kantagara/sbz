package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    Diagnosis save(Diagnosis bolest);

    Diagnosis findOne(Long id);

    List<Diagnosis> findAll();

    void remove(Long id);
}
