package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import java.util.HashSet;
import java.util.Set;

public class AllergyListDTO {

    Set<String> names;

    public AllergyListDTO(Set<String> names) {
        this.names = names;
    }

    public AllergyListDTO() {
        names = new HashSet<>();
    }

    public Set<String> getNames() {
        return names;
    }

    public void setNames(Set<String> names) {
        this.names = names;
    }
}
