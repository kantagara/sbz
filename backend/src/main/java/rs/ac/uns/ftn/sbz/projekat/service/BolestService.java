package rs.ac.uns.ftn.sbz.projekat.service;

import rs.ac.uns.ftn.sbz.projekat.model.Bolest;

import java.util.List;

public interface BolestService {

    Bolest save(Bolest bolest);

    Bolest findOne(Long id);

    List<Bolest> findAll();

    void remove(Bolest bolest);

    Bolest findByNaziv(String naziv);
}

