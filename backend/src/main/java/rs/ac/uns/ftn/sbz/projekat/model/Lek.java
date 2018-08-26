package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LEK")
public class Lek {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String naziv;

    @Column
    private TipLeka tipLeka;

    @ManyToMany
    private List<SastojakLeka> sastojci;

    public Lek() {
        sastojci = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public TipLeka getTipLeka() {
        return tipLeka;
    }

    public void setTipLeka(TipLeka tipLeka) {
        this.tipLeka = tipLeka;
    }

    public List<SastojakLeka> getSastojci() {
        return sastojci;
    }

    public void setSastojci(List<SastojakLeka> sastojci) {
        this.sastojci = sastojci;
    }
}
