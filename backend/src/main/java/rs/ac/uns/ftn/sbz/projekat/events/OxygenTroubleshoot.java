package rs.ac.uns.ftn.sbz.projekat.events;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class OxygenTroubleshoot {

    private String jmbg;

    public OxygenTroubleshoot(){}

    public OxygenTroubleshoot(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
