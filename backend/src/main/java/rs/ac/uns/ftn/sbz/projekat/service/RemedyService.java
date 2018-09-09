package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.Remedy;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.RemedyDTO;

import java.util.List;

public interface RemedyService {

    Remedy save(Remedy lek);

    Remedy findOne(Long id);

    List<Remedy> findAll();

    void remove(Remedy lek);

    Remedy findByNaziv(String naziv);

    void alter(RemedyDTO remedyDTO);

    boolean add(RemedyDTO remedyDTO);

    List<RemedyDTO> getAll();

    List<String> getAllIngridients();
}
