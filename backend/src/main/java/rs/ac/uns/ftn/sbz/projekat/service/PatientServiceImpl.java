package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Ingredient;
import rs.ac.uns.ftn.sbz.projekat.model.Patient;
import rs.ac.uns.ftn.sbz.projekat.model.Remedy;
import rs.ac.uns.ftn.sbz.projekat.repository.PatientRepository;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiagnosisDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.PatientDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RemedyService remedyService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private DiagnosisService diagnosisService;

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findOne(Long id) {
        return patientRepository.findOne(id);
    }

    @Override
    public List<PatientDTO> findAll() {

        List<Patient> patients = patientRepository.findAll();
        List<PatientDTO> dtos = new ArrayList<>();

        for(Patient patient: patients){
            PatientDTO patientDTO = new PatientDTO(patient.getName(), patient.getSurname(), patient.getJmbg());
            for(Remedy l : patient.getAllergicToRemedy())
                patientDTO.getAllergicToRemedy().add(l.getName());
            for(Ingredient s: patient.getAllergicToIngredient())
                patientDTO.getAllergicToIngredient().add(s.getName());
            dtos.add(patientDTO);
        }

        return dtos;
    }

    @Override
    public List<Patient> findAllFromDB() {
        return this.patientRepository.findAll();
    }

    @Override
    public void remove(Patient patient) {
        patientRepository.delete(findByJmbg(patient.getJmbg()).getId());
    }

    @Override
    public Patient findByJmbg(String jmbg) {
        return patientRepository.findByJmbg(jmbg);
    }

    @Override
    public boolean create(PatientDTO patientDTO) {

        if(this.findByJmbg(patientDTO.getJmbg()) != null)
            return false;

        Patient patient = new Patient(patientDTO.getName(), patientDTO.getSurname(), patientDTO.getJmbg(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        for(String remedy: patientDTO.getAllergicToRemedy()){
            patient.getAllergicToRemedy().add(this.remedyService.findByName(remedy));
        }

        for(String ingredient: patientDTO.getAllergicToIngredient()){
            patient.getAllergicToIngredient().add(this.ingredientService.findByNaziv(ingredient));
        }

        for(DiagnosisDTO diagnosisDTO : patientDTO.getDiagnosis())
            patient.getDiagnoses().add(diagnosisService.findOne(diagnosisDTO.getId()));

        save(patient);

        return true;
    }

    @Override
    public boolean update(PatientDTO patientDTO) {
        Patient patient = findByJmbg(patientDTO.getJmbg());
        if(patient == null)
            return false;

        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());

        List<Ingredient> ingredients = new ArrayList<>();

        for (Ingredient ingredient: patient.getAllergicToIngredient()){
            boolean postoji = false;

            for(String naziv_sastojka: patientDTO.getAllergicToIngredient()){
                if(ingredient.getName().equals(naziv_sastojka))
                    postoji = true;
            }
            if(!postoji) {
                ingredients.add(this.ingredientService.findByNaziv(ingredient.getName()));
            }
        }

        for(Ingredient ingredient: ingredients){
            patient.getAllergicToIngredient().remove(ingredient);
        }

        for(String name: patientDTO.getAllergicToIngredient()){
            Ingredient ingredient = this.ingredientService.findByNaziv(name);
            if(!patient.getAllergicToIngredient().contains(ingredient))
                patient.getAllergicToIngredient().add(ingredient);
        }

        List<Remedy> remedies = new ArrayList<>();

        for (Remedy lek: patient.getAllergicToRemedy()){
            boolean exists = false;

            for(String name: patientDTO.getAllergicToRemedy()){
                if(lek.getName().equals(name))
                    exists = true;
            }
            if(!exists) {
                remedies.add(this.remedyService.findByName(lek.getName()));
            }
        }

        for(Remedy lek: remedies){
            patient.getAllergicToRemedy().remove(lek);
        }

        for(String name: patientDTO.getAllergicToRemedy()){
            Remedy lek = this.remedyService.findByName(name);
            if(!patient.getAllergicToRemedy().contains(lek))
                patient.getAllergicToRemedy().add(lek);
        }
        save(patient);

        return true;
    }
}
