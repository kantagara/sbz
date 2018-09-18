package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import java.util.Set;

public class AllergyListDTO {

    Set<String> names;

    public AllergyListDTO(Set<String> names) {
        this.names = names;
    }

    public AllergyListDTO() {
    }

    public Set<String> getNames() {
        return names;
    }

    public void setNames(Set<String> names) {
        this.names = names;
    }
}
