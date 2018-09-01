package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.sbz.projekat.model.SastojakLeka;
import rs.ac.uns.ftn.sbz.projekat.repository.SastojakLekaRepository;

import java.util.List;

@Service
public class SastojakLekaServiceImpl implements SastojakLekaService{

    @Autowired
    private SastojakLekaRepository sastojakLekaRepository;


    @Override
    public SastojakLeka findOne(Long id) {
        return this.sastojakLekaRepository.findOne(id);
    }

    @Override
    public SastojakLeka save(SastojakLeka SastojakLeka) {
        return this.sastojakLekaRepository.save(SastojakLeka);
    }


    @Override
    public void remove(SastojakLeka SastojakLeka) {
        this.sastojakLekaRepository.delete(SastojakLeka.getId());
    }

    @Override
    public List<SastojakLeka> findAll(){
        return this.sastojakLekaRepository.findAll();
    }

    @Override
    public SastojakLeka findByNaziv(String naziv){
        return this.sastojakLekaRepository.findByNaziv(naziv);
    }
}
