package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.sbz.projekat.model.Bolest;
import rs.ac.uns.ftn.sbz.projekat.repository.BolestRepository;

import java.util.List;


@Service
public class BolestServiceImpl implements BolestService{

    @Autowired
    private BolestRepository bolestRepository;

    @Override
    public Bolest save(Bolest bolest) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Bolest findOne(Long id) {
        return this.bolestRepository.findOne(id);
    }


    @Override
    public void remove(Bolest bolest) {

    }

    @Override
    public List<Bolest> findAll(){
        return this.bolestRepository.findAll();
    }

    @Override
    public Bolest findByNaziv(String naziv){
        return this.bolestRepository.findByNaziv(naziv);
    }
}
