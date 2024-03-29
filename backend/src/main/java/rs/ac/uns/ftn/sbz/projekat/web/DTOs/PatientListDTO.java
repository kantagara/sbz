package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import java.util.ArrayList;
import java.util.List;

public class PatientListDTO {
    private List<PatientDTO> patients;

    public PatientListDTO(List<PatientDTO> patients) {
        this.patients = patients;
    }

    public PatientListDTO() {
        patients = new ArrayList<>();
    }

    public List<PatientDTO> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientDTO> patients) {
        this.patients = patients;
    }
}
