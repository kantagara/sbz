package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.Authority;

public interface AuthorityService {

    Authority save(Authority authority);
    void remove(Long id);
}
