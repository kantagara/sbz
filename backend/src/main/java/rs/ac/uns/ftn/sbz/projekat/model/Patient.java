package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    private String jmbg;

    @ManyToMany
    private List<Ingredient> allergicToIngredient;

    @ManyToMany
    private List<Remedy> allergicToRemedy;

    @OneToMany
    private List<Diagnosis> diagnoses;


    public Patient() {
        allergicToIngredient = new ArrayList<>();
    }

    public Patient(String name, String surname, String jmbg, List<Ingredient> allergicToIngredient, List<Remedy> allergicToRemedy) {
        this.name = name;
        this.surname = surname;
        this.jmbg = jmbg;
        this.allergicToIngredient = allergicToIngredient;
        this.allergicToRemedy = allergicToRemedy;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Ingredient> getAllergicToIngredient() {
        return allergicToIngredient;
    }

    public void setAllergicToIngredient(List<Ingredient> allergicToIngredient) {
        this.allergicToIngredient = allergicToIngredient;
    }

    public List<Remedy> getAllergicToRemedy() {
        return allergicToRemedy;
    }

    public void setAllergicToRemedy(List<Remedy> allergicToRemedy) {
        this.allergicToRemedy = allergicToRemedy;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
