package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

public class SymptomDTO {

    private String name;
    private Double value;

    public SymptomDTO(){}

    public SymptomDTO(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SymptomDTO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
