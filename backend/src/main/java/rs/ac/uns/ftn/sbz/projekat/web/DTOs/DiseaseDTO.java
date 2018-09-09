package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import rs.ac.uns.ftn.sbz.projekat.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class DiseaseDTO {

    private String name;
    private List<SymptomDTO> general;
    private List<SymptomDTO> specific;

    public DiseaseDTO(){
        this.general = new ArrayList<>();
        this.specific = new ArrayList<>();
    }

    public DiseaseDTO(String name, List<SymptomDTO> general, List<SymptomDTO> specific) {
        this.name = name;
        this.general = general;
        this.specific = specific;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SymptomDTO> getGeneral() {
        return general;
    }

    public void setGeneral(List<SymptomDTO> general) {
        this.general = general;
    }

    public List<SymptomDTO> getSpecific() {
        return specific;
    }

    public void setSpecific(List<SymptomDTO> specific) {
        this.specific = specific;
    }
}
