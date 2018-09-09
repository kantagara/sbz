package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

public class TokenDTO {
    private String value;

    public TokenDTO(String value) {
        this.value = value;
    }

    public TokenDTO() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
