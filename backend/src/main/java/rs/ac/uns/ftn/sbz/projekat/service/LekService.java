package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.Lek;

import java.util.List;

public interface LekService {

    Lek save(Lek lek);

    Lek findOne(Long id);

    List<Lek> findAll();

    void remove(Lek lek);

    Lek findByNaziv(String naziv);
}
