package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.sbz.projekat.model.Dijagnoza;
import rs.ac.uns.ftn.sbz.projekat.repository.DijagnozaRepository;
import java.util.List;

@Service
public class DijagnozaServiceImpl implements DijagnozaService{

    @Autowired
    private DijagnozaRepository dijagnozaRepository;

    @Override
    public Dijagnoza findOne(Long id) {
        return this.dijagnozaRepository.findOne(id);
    }

    @Override
    public Dijagnoza save(Dijagnoza dijagnoza) {
        return this.dijagnozaRepository.save(dijagnoza);
    }


    @Override
    public void remove(Long id) {
        this.dijagnozaRepository.delete(id);
    }

    @Override
    public List<Dijagnoza> findAll(){
        return this.dijagnozaRepository.findAll();
    }
}
