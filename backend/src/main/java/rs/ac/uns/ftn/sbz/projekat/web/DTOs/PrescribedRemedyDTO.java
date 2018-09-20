package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import java.util.ArrayList;
import java.util.List;

public class PrescribedRemedyDTO {

    private Long diagnosisId;
    private List<RemedyDTO> remedies;

    public PrescribedRemedyDTO() {
        remedies = new ArrayList<>();
    }

    public PrescribedRemedyDTO(Long diagnosisId, List<RemedyDTO> remedies) {
        this.diagnosisId = diagnosisId;
        this.remedies = remedies;
    }

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public List<RemedyDTO> getRemedies() {
        return remedies;
    }

    public void setRemedies(List<RemedyDTO> remedies) {
        this.remedies = remedies;
    }
}
