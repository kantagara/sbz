package rs.ac.uns.ftn.sbz.projekat.events;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class DialysisEvent {

    private String jmbg;

    public DialysisEvent() {
    }

    public DialysisEvent(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
