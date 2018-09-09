package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;
import rs.ac.uns.ftn.sbz.projekat.model.Ingredient;
import rs.ac.uns.ftn.sbz.projekat.model.Patient;
import rs.ac.uns.ftn.sbz.projekat.model.Remedy;

import java.util.ArrayList;
import java.util.List;

public class PatientDTO {

    private String name;
    private String surname;
    private String jmbg;
    private List<String> allergicToRemedy;
    private List<String> allergicToIngredient;
    private List<DiagnosisDTO> diagnosis;



    public PatientDTO() {
    }

    public PatientDTO(String name, String surname, String jmbg) {
        this.name = name;
        this.surname = surname;
        this.jmbg = jmbg;
        allergicToIngredient = new ArrayList<>();
        allergicToRemedy = new ArrayList<>();
    }

    public PatientDTO(String name, String surname, String jmbg, List<String> allergicToRemedy, List<String> allergicToIngredient, List<DiagnosisDTO> diagnosis) {
        this.name = name;
        this.surname = surname;
        this.jmbg = jmbg;
        this.allergicToRemedy = allergicToRemedy;
        this.allergicToIngredient = allergicToIngredient;
        this.diagnosis = diagnosis;
    }

    public PatientDTO(Patient patient) {
        allergicToRemedy = new ArrayList<>();
        allergicToIngredient = new ArrayList<>();
        diagnosis = new ArrayList<>();

        this.name = patient.getName();
        this.surname = patient.getSurname();

        for(Remedy remedy: patient.getAllergicToRemedy())
            allergicToRemedy.add(remedy.getName());

        for(Ingredient ingredient: patient.getAllergicToIngredient())
            allergicToIngredient.add(ingredient.getName());

        for(Diagnosis dig : patient.getDiagnoses())
            diagnosis.add(new DiagnosisDTO(dig));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public List<String> getAllergicToRemedy() {
        return allergicToRemedy;
    }

    public void setAllergicToRemedy(List<String> allergicToRemedy) {
        this.allergicToRemedy = allergicToRemedy;
    }

    public List<String> getAllergicToIngredient() {
        return allergicToIngredient;
    }

    public void setAllergicToIngredient(List<String> allergicToIngredient) {
        this.allergicToIngredient = allergicToIngredient;
    }

    public List<DiagnosisDTO> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<DiagnosisDTO> diagnosis) {
        this.diagnosis = diagnosis;
    }
}
