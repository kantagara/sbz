package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;

@Entity
@Table
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String name;

    @Column
    private Double value;


    public Symptom(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Symptom() {}

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symptom symptom = (Symptom) o;

        if (id != null ? !id.equals(symptom.id) : symptom.id != null) return false;
        return name != null ? name.equals(symptom.name) : symptom.name == null;
    }

}
