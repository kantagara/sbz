package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

public class SymptomDTO {

    private String name;

    public SymptomDTO(){}

    public SymptomDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
