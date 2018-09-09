package rs.ac.uns.ftn.sbz.projekat.service;

import rs.ac.uns.ftn.sbz.projekat.model.Disease;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiseaseDTO;

import java.util.List;

public interface DiseaseService {

    Disease save(Disease disease);

    Disease findOne(Long id);

    List<DiseaseDTO> findAll();

    boolean remove(String name);

    Disease findByName(String name);

    boolean add(DiseaseDTO diseaseDTO);

    void update(DiseaseDTO diseaseDTO);
}

