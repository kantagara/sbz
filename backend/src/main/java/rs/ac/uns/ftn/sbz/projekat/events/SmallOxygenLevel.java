package rs.ac.uns.ftn.sbz.projekat.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("20m")
public class SmallOxygenLevel implements Serializable{

    private String jmbg;

    public SmallOxygenLevel() {
        super();
    }

    public SmallOxygenLevel(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
