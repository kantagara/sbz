package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFound;
import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFoundList;

import java.util.ArrayList;
import java.util.List;

public class DiseaseFoundListDTO {

    List<DiseaseFoundDTO> diseases;


    public DiseaseFoundListDTO(List<DiseaseFoundDTO> diseases) {
        this.diseases = diseases;
    }

    public DiseaseFoundListDTO() {
    }

    public DiseaseFoundListDTO(DiseaseFoundList d){
        diseases = new ArrayList<>();
        if(d.getDiseases().size() == 0) return;
        addDiseasesToList(d);
    }

    private void addDiseasesToList(DiseaseFoundList d) {

        if(!d.isOnlyOne())
            for (DiseaseFound df :
                    d.getDiseases()) {
                diseases.add(new DiseaseFoundDTO(df));
            }
        else{
            DiseaseFound df = d.getDiseases().get(0);
            for(int i = 1; i < d.getDiseases().size(); i++){

                if(df.getWeight().equals(d.getDiseases().get(i).getWeight()))
                    if(df.getDisease().getGeneralSymptoms().size() < d.getDiseases().get(i).getDisease().getGeneralSymptoms().size())
                        df = d.getDiseases().get(i);
            }
            diseases.add(new DiseaseFoundDTO(df));
        }
    }

    public List<DiseaseFoundDTO> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<DiseaseFoundDTO> diseases) {
        this.diseases = diseases;
    }



}
