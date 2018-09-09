package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Account doctor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Patient patient;

    @ManyToMany
    private List<Symptom> symptoms;

    @ManyToMany
    private List<Remedy> therapy;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Disease disease;


    public Diagnosis(){
    }

    public Diagnosis(Date dateCreated, Account doctor, Patient patient, List<Symptom> symptoms, List<Remedy> terapija) {
        this.dateCreated = dateCreated;
        this.doctor = doctor;
        this.patient = patient;
        this.symptoms = symptoms;
        this.therapy = terapija;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Account getDoctor() {
        return doctor;
    }

    public void setDoctor(Account doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public List<Remedy> getTherapy() {
        return therapy;
    }

    public void setTherapy(List<Remedy> therapy) {
        this.therapy = therapy;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
