package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;

@Entity
@Table
public class Simptom {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String nazivSimptoma;

}
