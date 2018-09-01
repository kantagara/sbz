package rs.ac.uns.ftn.sbz.projekat.service;

import rs.ac.uns.ftn.sbz.projekat.model.Pacijent;

import java.util.List;

public interface PacijentService {

    Pacijent save(Pacijent pacijent);

    Pacijent findOne(Long id);

    List<Pacijent> findAll();

    void remove(Pacijent pacijent);

    Pacijent findByJmbg(String jmbg);
}
