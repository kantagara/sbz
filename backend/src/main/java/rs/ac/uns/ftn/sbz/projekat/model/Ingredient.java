package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    private List<Patient> patientsAllergicTo;

    public Ingredient() {
        this.patientsAllergicTo = new ArrayList<>();
    }


    public Ingredient(String sas) {
        this.patientsAllergicTo = new ArrayList<>();
        this.name = sas;
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

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatientsAllergicTo() {
        return patientsAllergicTo;
    }

    public void setPatientsAllergicTo(List<Patient> patientsAllergicTo) {
        this.patientsAllergicTo = patientsAllergicTo;
    }
}
