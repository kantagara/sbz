package rs.ac.uns.ftn.sbz.projekat.service;

import rs.ac.uns.ftn.sbz.projekat.model.Patient;
import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFoundList;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.*;

public interface DroolsService {


    DiseaseFoundListDTO getDiseaseBySymptoms(DiagnosisDTO diagnosisDTO, Patient patient, boolean onlyOne);

    DiagnosisDTO getDisease(DiagnosisDTO diagnosisDTO);

    DiagnosisDTO personalDiagnosis(DiagnosisDTO diagnosisDTO);

    DiseaseDTO getSymptomsByDisease(String name);

    AllergyListDTO allergies(Long diagnosisId);

    PatientListDTO chronics();
    PatientListDTO addictions();
    PatientListDTO lowImmunity();
}
