package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Disease")
public class Disease
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    private List<Symptom> generalSymptoms;

    @ManyToMany
    private List<Symptom> specificSymptoms;

    public Disease(String name, List<Symptom> generalSymptoms, List<Symptom> specificSymptoms) {
        this.name = name;
        this.generalSymptoms = generalSymptoms;
        this.specificSymptoms = specificSymptoms;
    }

    public Disease(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Symptom> getGeneralSymptoms() {
        return generalSymptoms;
    }

    public void setGeneralSymptoms(List<Symptom> generalSymptoms) {
        this.generalSymptoms = generalSymptoms;
    }

    public List<Symptom> getSpecificSymptoms() {
        return specificSymptoms;
    }

    public void setSpecificSymptoms(List<Symptom> specificSymptoms) {
        this.specificSymptoms = specificSymptoms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
