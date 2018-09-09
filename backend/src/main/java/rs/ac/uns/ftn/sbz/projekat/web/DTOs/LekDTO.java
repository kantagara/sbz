package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import rs.ac.uns.ftn.sbz.projekat.model.RemedyType;

import java.util.ArrayList;
import java.util.List;

public class LekDTO {

    private String naziv;
    private List<String> sastojci;
    private RemedyType remedyType;

    public LekDTO(){
        this.sastojci = new ArrayList<>();
    }

    public LekDTO(String naziv, List<String> sastojci, RemedyType remedyType) {
        this.naziv = naziv;
        this.sastojci = sastojci;
        this.remedyType = remedyType;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<String> getSastojci() {
        return sastojci;
    }

    public void setSastojci(List<String> sastojci) {
        this.sastojci = sastojci;
    }

    public RemedyType getRemedyType() {
        return remedyType;
    }

    public void setRemedyType(RemedyType remedyType) {
        this.remedyType = remedyType;
    }
}
