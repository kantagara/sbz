package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.sbz.projekat.model.Authority;
import rs.ac.uns.ftn.sbz.projekat.repository.AuthorityRepository;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    @Transactional(readOnly = false)
    public Authority save(Authority authority) {
        return this.authorityRepository.save(authority);
    }

    @Override
    @Transactional
    public void remove(Long id){
        this.authorityRepository.delete(id);
    }


}
