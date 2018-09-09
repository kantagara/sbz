package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Remedy")
public class Remedy {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String name;

    @Column
    private RemedyType remedyType;

    @ManyToMany
    private List<Ingredient> sastojci;

    public Remedy() {
        sastojci = new ArrayList<>();
    }

    public Remedy(RemedyType remedyType, String name, List<Ingredient> sastojciLeka) {
        this.remedyType = remedyType;
        this.name = name;
        this.sastojci = sastojciLeka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String naziv) {
        this.name = naziv;
    }

    public RemedyType getRemedyType() {
        return remedyType;
    }

    public void setRemedyType(RemedyType remedyType) {
        this.remedyType = remedyType;
    }

    public List<Ingredient> getSastojci() {
        return sastojci;
    }

    public void setSastojci(List<Ingredient> sastojci) {
        this.sastojci = sastojci;
    }
}
