package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Pacijent;
import rs.ac.uns.ftn.sbz.projekat.repository.PacijentRepository;

import java.util.List;

@Service
public class PacijentServiceImpl implements PacijentService{


    @Autowired
    private PacijentRepository pacijentRepository;


    @Override
    public Pacijent save(Pacijent pacijent) {
        return pacijentRepository.save(pacijent);
    }

    @Override
    public Pacijent findOne(Long id) {
        return pacijentRepository.findOne(id);
    }

    @Override
    public List<Pacijent> findAll() {
        return pacijentRepository.findAll();
    }

    @Override
    public void remove(Pacijent pacijent) {
        pacijentRepository.delete(findByJmbg(pacijent.getJmbg()).getId());
    }

    @Override
    public Pacijent findByJmbg(String jmbg) {
        return pacijentRepository.findByJmbg(jmbg);
    }
}
