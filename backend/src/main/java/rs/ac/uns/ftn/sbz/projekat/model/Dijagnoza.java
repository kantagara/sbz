package rs.ac.uns.ftn.sbz.projekat.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Dijagnoza")
public class Dijagnoza {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private Date datumUspostavjlanjaDijagnoze;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Account lekar;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Pacijent pacijent;

    @ManyToMany
    private List<Simptom> simptomi;

    @ManyToMany
    private List<Lek> terapija;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Bolest bolest;


    public Dijagnoza(){
    }

    public Dijagnoza(Date datumUspostavjlanjaDijagnoze, Account lekar, Pacijent pacijent, List<Simptom> simptomi, List<Lek> terapija) {
        this.datumUspostavjlanjaDijagnoze = datumUspostavjlanjaDijagnoze;
        this.lekar = lekar;
        this.pacijent = pacijent;
        this.simptomi = simptomi;
        this.terapija = terapija;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumUspostavjlanjaDijagnoze() {
        return datumUspostavjlanjaDijagnoze;
    }

    public void setDatumUspostavjlanjaDijagnoze(Date datumUspostavjlanjaDijagnoze) {
        this.datumUspostavjlanjaDijagnoze = datumUspostavjlanjaDijagnoze;
    }

    public Account getLekar() {
        return lekar;
    }

    public void setLekar(Account lekar) {
        this.lekar = lekar;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public List<Simptom> getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(List<Simptom> simptomi) {
        this.simptomi = simptomi;
    }

    public List<Lek> getTerapija() {
        return terapija;
    }

    public void setTerapija(List<Lek> terapija) {
        this.terapija = terapija;
    }

    public Bolest getBolest() {
        return bolest;
    }

    public void setBolest(Bolest bolest) {
        this.bolest = bolest;
    }
}
