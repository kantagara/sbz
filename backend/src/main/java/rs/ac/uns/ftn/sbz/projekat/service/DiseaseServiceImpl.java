package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.sbz.projekat.model.Disease;
import rs.ac.uns.ftn.sbz.projekat.model.Symptom;
import rs.ac.uns.ftn.sbz.projekat.repository.DiseaseRepository;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiseaseDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.SymptomDTO;

import java.util.ArrayList;
import java.util.List;


@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private SymptomService symptomService;

    @Override
    public Disease save(Disease disease) {
        return this.diseaseRepository.save(disease);
    }

    @Override
    @Transactional(readOnly = true)
    public Disease findOne(Long id) {
        return this.diseaseRepository.findOne(id);
    }


    @Override
    public boolean remove(String name) {

        Disease disease = findByName(name);

        if(disease == null)
            return false;

        this.diseaseRepository.delete(disease.getId());

        return true;
    }

    @Override
    public List<DiseaseDTO> findAll(){

        List<Disease> diseases = diseaseRepository.findAll();
        List<DiseaseDTO> dtos = new ArrayList<>();

        for(Disease disease: diseases){
            List<SymptomDTO> general = new ArrayList<>();
            List<SymptomDTO> specific = new ArrayList<>();

            for(Symptom symptom: disease.getGeneralSymptoms())
                general.add(new SymptomDTO(symptom.getName(), symptom.getValue()));

            for(Symptom symptom: disease.getSpecificSymptoms())
                specific.add(new SymptomDTO(symptom.getName(), symptom.getValue()));
            dtos.add(new DiseaseDTO(disease.getName(), general, specific));
        }

        return dtos;
    }

    @Override
    public Disease findByName(String name){
        return this.diseaseRepository.findByName(name);
    }

    @Override
    public boolean add(DiseaseDTO diseaseDTO) {

        Disease exists = findByName(diseaseDTO.getName());

        if(exists != null)
            return false;

        List<Symptom> general = new ArrayList<>();
        List<Symptom> specific = new ArrayList<>();

        for(SymptomDTO symptom: diseaseDTO.getGeneral()){
            Symptom s = this.symptomService.findByName(symptom.getName());
            if(s == null)
                return false;
            general.add(s);
        }

        for(SymptomDTO symptom: diseaseDTO.getSpecific()){
            Symptom s = this.symptomService.findByName(symptom.getName());
            if(s == null)
                return false;
            specific.add(this.symptomService.findByName(symptom.getName()));
        }

        save(new Disease(diseaseDTO.getName(), general, specific));

        return true;
    }

    @Override
    public void update(DiseaseDTO diseaseDTO) {
        Disease disease = findByName(diseaseDTO.getName());

        List<Symptom> general = new ArrayList<>();
        List<Symptom> specific = new ArrayList<>();


        for (Symptom symptom: disease.getGeneralSymptoms()){
            boolean exists = false;
            for(SymptomDTO symptomDTO: diseaseDTO.getGeneral()){
                if(symptom.getName().equals(symptomDTO.getName()))
                    exists = true;
            }
            if(!exists) {
                general.add(this.symptomService.findByName(symptom.getName()));
            }
        }

        for (Symptom symptom: disease.getSpecificSymptoms()){
            boolean exists = false;
            for(SymptomDTO symptomDTO: diseaseDTO.getSpecific()){
                if(symptom.getName().equals(symptomDTO.getName()))
                    exists = true;
            }
            if(!exists) {
                specific.add(symptomService.findByName(symptom.getName()));
            }
        }

        for(Symptom s : general){
            disease.getGeneralSymptoms().remove(s);
        }

        for(Symptom s : specific){
            disease.getSpecificSymptoms().remove(s);
        }


        for(SymptomDTO symptomDTO: diseaseDTO.getGeneral()){
            Symptom symptom = this.symptomService.findByName(symptomDTO.getName());
            if(!disease.getGeneralSymptoms().contains(symptom))
                disease.getGeneralSymptoms().add(symptom);
        }

        for(SymptomDTO symptomDTO: diseaseDTO.getSpecific()){
            Symptom symptom = this.symptomService.findByName(symptomDTO.getName());
            if(!disease.getSpecificSymptoms().contains(symptom))
                disease.getSpecificSymptoms().add(symptom);
        }

        save(disease);
    }
}
