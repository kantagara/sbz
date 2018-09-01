package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SASTOJAK_LEKA")
public class SastojakLeka {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String naziv;

    @ManyToMany
    private List<Pacijent> pacijentiAlergicniNa;

    public SastojakLeka() {
        this.pacijentiAlergicniNa = new ArrayList<>();
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

    public List<Pacijent> getPacijentiAlergicniNa() {
        return pacijentiAlergicniNa;
    }

    public void setPacijentiAlergicniNa(List<Pacijent> pacijentiAlergicniNa) {
        this.pacijentiAlergicniNa = pacijentiAlergicniNa;
    }
}
