package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.Symptom;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.SymptomDTO;

import java.util.List;

public interface SymptomService {

    Symptom save(Symptom symptom);

    Symptom findOne(Long id);

    List<SymptomDTO> findAll();

    boolean remove(String name);

    Symptom findByName(String name);

    boolean add(SymptomDTO symptomDTO);
}
