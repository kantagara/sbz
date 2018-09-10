package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;
import rs.ac.uns.ftn.sbz.projekat.repository.DiagnosisRepository;
import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis findOne(Long id) {
        return this.diagnosisRepository.findOne(id);
    }

    @Override
    public Diagnosis save(Diagnosis diagnosis) {
        return this.diagnosisRepository.save(diagnosis);
    }


    @Override
    public void remove(Long id) {
        this.diagnosisRepository.delete(id);
    }

    @Override
    public List<Diagnosis> findAll(){
        return this.diagnosisRepository.findAll();
    }
}
