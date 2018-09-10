package rs.ac.uns.ftn.sbz.projekat.events;


import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;

public class IntensiveCare {

    private String jmbg;
    private Diagnosis Diagnosis;
    private int oxygenLevel;


    public IntensiveCare() {
    }

    public IntensiveCare(String jmbg, Diagnosis Diagnosis, int oxygenLevel) {
        this.jmbg = jmbg;
        this.Diagnosis = Diagnosis;
        this.oxygenLevel = oxygenLevel;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Diagnosis getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(Diagnosis Diagnosis) {
        this.Diagnosis = Diagnosis;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(int oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }
}
