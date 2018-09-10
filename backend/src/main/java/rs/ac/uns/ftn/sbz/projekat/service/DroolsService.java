package rs.ac.uns.ftn.sbz.projekat.service;

import rs.ac.uns.ftn.sbz.projekat.model.Patient;
import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFoundList;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiagnosisDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiseaseFoundListDTO;

public interface DroolsService {


    DiseaseFoundListDTO getDiseaseBySymptoms(DiagnosisDTO diagnosisDTO, Patient patient, boolean onlyOne);
}
