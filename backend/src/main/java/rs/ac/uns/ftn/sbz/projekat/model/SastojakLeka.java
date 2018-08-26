package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;

@Entity
@Table(name = "SASTOJAK_LEKA")
public class SastojakLeka {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String naziv;

    public SastojakLeka() {
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
}
