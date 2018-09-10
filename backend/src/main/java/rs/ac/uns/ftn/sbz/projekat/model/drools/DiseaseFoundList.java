package rs.ac.uns.ftn.sbz.projekat.model.drools;

import rs.ac.uns.ftn.sbz.projekat.model.Disease;

import java.util.ArrayList;
import java.util.List;

public class DiseaseFoundList {

    List<DiseaseFound> diseases;
    private boolean onlyOne;


    public DiseaseFoundList(List<DiseaseFound> diseases, boolean onlyOne) {
        this.diseases = diseases;
        this.onlyOne = onlyOne;
    }

    public DiseaseFoundList(){
        this.diseases = new ArrayList<>();
    }

    public List<DiseaseFound> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<DiseaseFound> diseases) {
        this.diseases = diseases;
    }

    public boolean isOnlyOne() {
        return onlyOne;
    }

    public void setOnlyOne(boolean onlyOne) {
        this.onlyOne = onlyOne;
    }
}
