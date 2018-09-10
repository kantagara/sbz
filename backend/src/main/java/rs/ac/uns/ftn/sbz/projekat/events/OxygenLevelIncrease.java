package rs.ac.uns.ftn.sbz.projekat.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("20m")
public class OxygenLevelIncrease implements Serializable {

    private String jmbg;
    private Double level;

    public OxygenLevelIncrease() {
        super();
    }

    public OxygenLevelIncrease(String jmbg, Double level) {
        this.jmbg = jmbg;
        this.level = level;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }
}
