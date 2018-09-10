package rs.ac.uns.ftn.sbz.projekat.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("10m")
public class Heartbeat implements Serializable{

    private String jmbg;

    public Heartbeat() {
        super();
    }

    public Heartbeat(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
