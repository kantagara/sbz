package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisDTO {

    private String disease;
    private String date;
    private String jmbg;
    private List<SymptomDTO> symtpoms;
    private List<RemedyDTO> remedy;
    private Long id;


    public DiagnosisDTO(){
        symtpoms= new ArrayList<>();
    }

    public DiagnosisDTO(String disease,String jmbg, String date, List<SymptomDTO> symtpoms, Long id) {
        this.disease = disease;
        this.date = date;
        this.jmbg = jmbg;
        this.symtpoms = symtpoms;
        this.id = id;
    }

    public DiagnosisDTO(Diagnosis diagnosis){
        symtpoms = new ArrayList<>();
        remedy = new ArrayList<>();
        id = diagnosis.getId();
        jmbg = diagnosis.getPatient().getJmbg();
        date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(diagnosis.getDateCreated());
        diagnosis.getSymptoms().forEach(s -> symtpoms.add(new SymptomDTO(s.getName(), s.getValue())));
        diagnosis.getTherapy().forEach(t -> remedy.add(new RemedyDTO(t)));
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SymptomDTO> getSymtpoms() {
        return symtpoms;
    }

    public void setSymtpoms(List<SymptomDTO> symtpoms) {
        this.symtpoms = symtpoms;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
