package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.sbz.projekat.model.Lek;
import rs.ac.uns.ftn.sbz.projekat.repository.LekRepository;

import java.util.List;

@Service
public class LekServiceImpl implements LekService{

    @Autowired
    private LekRepository lekRepository;

    @Override
    public Lek findOne(Long id) {
        return this.lekRepository.findOne(id);
    }

    @Override
    public Lek save(Lek lek) {
        return this.lekRepository.save(lek);
    }


    @Override
    public void remove(Lek lek) {
        this.lekRepository.delete(lek.getId());
    }

    @Override
    public List<Lek> findAll(){
        return this.lekRepository.findAll();
    }

    @Override
    public Lek findByNaziv(String naziv){
        return this.lekRepository.findByNaziv(naziv);
    }
}
