package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pacijent")
public class Pacijent {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String jmbg;

    @ManyToMany
    private List<SastojakLeka> alergicanNaSastojak;

    @ManyToMany
    private List<Lek> alergicanNaLek;


    public Pacijent() {
        alergicanNaSastojak = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public List<SastojakLeka> getAlergicanNaSastojak() {
        return alergicanNaSastojak;
    }

    public void setAlergicanNaSastojak(List<SastojakLeka> alergicanNaSastojak) {
        this.alergicanNaSastojak = alergicanNaSastojak;
    }

    public List<Lek> getAlergicanNaLek() {
        return alergicanNaLek;
    }

    public void setAlergicanNaLek(List<Lek> alergicanNaLek) {
        this.alergicanNaLek = alergicanNaLek;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
