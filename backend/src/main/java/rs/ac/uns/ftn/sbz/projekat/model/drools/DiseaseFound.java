package rs.ac.uns.ftn.sbz.projekat.model.drools;

import rs.ac.uns.ftn.sbz.projekat.model.Disease;

public class DiseaseFound {

    private Disease disease;
    private Double weight;

    public DiseaseFound(Disease disease, int k, int total) {
        this.disease = disease;
        this.weight = (double)k/(double)total;
    }

    public DiseaseFound() {
    }


    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
