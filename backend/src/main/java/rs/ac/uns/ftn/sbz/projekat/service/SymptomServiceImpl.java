package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.sbz.projekat.model.Disease;
import rs.ac.uns.ftn.sbz.projekat.model.Symptom;
import rs.ac.uns.ftn.sbz.projekat.repository.DiseaseRepository;
import rs.ac.uns.ftn.sbz.projekat.repository.SymptomRepository;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.SymptomDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomServiceImpl implements SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public Symptom findOne(Long id) {
        return this.symptomRepository.findOne(id);
    }

    @Override
    public Symptom save(Symptom symptom) {
        return this.symptomRepository.save(symptom);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SymptomDTO> findAll(){

        List<Symptom> symptoms = symptomRepository.findAll();
        List<SymptomDTO> dtos = new ArrayList<>();
        for(Symptom s: symptoms){
            dtos.add(new SymptomDTO(s.getName(), s.getValue()));
        }

        return dtos;
    }

    @Override
    public boolean remove(String name) {
        Symptom symptom = findByName(name);
        if(symptom == null)
            return false;

        List<Disease> diseases = diseaseRepository.findAllWhoContainSymptom(symptom.getId());
        for (Disease disease :
                diseases) {
            disease.getGeneralSymptoms().remove(symptom);
        }

        this.diseaseRepository.save(diseases);

        symptomRepository.delete(symptom);

        return true;
    }

    @Override
    public Symptom findByName(String naziv){
        return this.symptomRepository.findByName(naziv);
    }

    @Override
    public Symptom findByNameAndValue(String name, Double value) {
        return this.symptomRepository.findByNameAndValue(name, value);
    }

    @Override
    public Symptom findByNameAndValueGreaterThan(String name, Double value) {
        return symptomRepository.findByNameAndValueGreaterThanEqual(name, value);
    }


    @Override
    public boolean add(SymptomDTO symptomDTO) {
        Symptom exists = findByName(symptomDTO.getName());
        if(exists != null)
            return false;

        Symptom symptom = new Symptom(symptomDTO.getName(), symptomDTO.getValue());
        save(symptom);

        return true;
    }

}
