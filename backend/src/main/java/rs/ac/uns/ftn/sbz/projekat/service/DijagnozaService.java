package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.Dijagnoza;

import java.util.List;

public interface DijagnozaService {

    Dijagnoza save(Dijagnoza bolest);

    Dijagnoza findOne(Long id);

    List<Dijagnoza> findAll();

    void remove(Long id);
}
