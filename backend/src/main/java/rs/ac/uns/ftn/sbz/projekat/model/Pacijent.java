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

    @ManyToMany
    private List<SastojakLeka> alergicanNa;


    public Pacijent() {
        alergicanNa = new ArrayList<>();
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

    public List<SastojakLeka> getAlergicanNa() {
        return alergicanNa;
    }

    public void setAlergicanNa(List<SastojakLeka> alergicanNa) {
        this.alergicanNa = alergicanNa;
    }
}
