package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Bolest")
public class Bolest
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String naziv;

    @ManyToMany
    private List<Simptom> opstiSimptomi;

    @ManyToMany
    private List<Simptom> specificniSimptomi;

    public Bolest(String naziv, List<Simptom> opstiSimptomi, List<Simptom> specificniSimptomi) {
        this.naziv = naziv;
        this.opstiSimptomi = opstiSimptomi;
        this.specificniSimptomi = specificniSimptomi;
    }

    public Bolest(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Simptom> getOpstiSimptomi() {
        return opstiSimptomi;
    }

    public void setOpstiSimptomi(List<Simptom> opstiSimptomi) {
        this.opstiSimptomi = opstiSimptomi;
    }

    public List<Simptom> getSpecificniSimptomi() {
        return specificniSimptomi;
    }

    public void setSpecificniSimptomi(List<Simptom> specificniSimptomi) {
        this.specificniSimptomi = specificniSimptomi;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
