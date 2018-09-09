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

    public Symptom(String name) {
        this.name = name;
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
}
