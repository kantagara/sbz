package rs.ac.uns.ftn.sbz.projekat.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("20m")
public class Urinating implements Serializable{

    private String jmbg;

    private int amount;

    public Urinating(){
        super();
    }

    public Urinating(String jmbg, int amount) {
        this.jmbg = jmbg;
        this.amount = amount;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
