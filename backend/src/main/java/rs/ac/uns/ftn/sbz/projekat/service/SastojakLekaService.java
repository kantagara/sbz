package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.SastojakLeka;

import java.util.List;

public interface SastojakLekaService {

    SastojakLeka save(SastojakLeka SastojakLeka);

    SastojakLeka findOne(Long id);

    List<SastojakLeka> findAll();

    void remove(SastojakLeka SastojakLeka);

    SastojakLeka findByNaziv(String naziv);
}
