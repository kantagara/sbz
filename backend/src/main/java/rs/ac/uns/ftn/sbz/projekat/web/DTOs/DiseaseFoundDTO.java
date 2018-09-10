package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFound;

public class DiseaseFoundDTO {

    private DiseaseDTO disease;
    private Double weight;


    public DiseaseFoundDTO(DiseaseDTO disease, Double weight) {
        this.disease = disease;
        this.weight = weight;
    }

    public DiseaseFoundDTO() {
    }

    public DiseaseFoundDTO(DiseaseFound d){
        disease = new DiseaseDTO(d.getDisease());
        weight = d.getWeight();
    }

    public DiseaseDTO getDisease() {
        return disease;
    }

    public void setDisease(DiseaseDTO disease) {
        this.disease = disease;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
