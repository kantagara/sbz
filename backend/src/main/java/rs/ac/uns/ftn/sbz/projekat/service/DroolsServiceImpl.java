package rs.ac.uns.ftn.sbz.projekat.service;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;
import rs.ac.uns.ftn.sbz.projekat.model.Patient;
import rs.ac.uns.ftn.sbz.projekat.model.Symptom;
import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFound;
import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFoundList;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiagnosisDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiseaseFoundListDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.SymptomDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DroolsServiceImpl implements DroolsService {


    private final KieSession kieSession;

    @Autowired
    private SymptomService symptomService;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    public DroolsServiceImpl(KieSession kieSession)
    {
        this.kieSession = kieSession;
    }


    @Override
    public DiseaseFoundListDTO getDiseaseBySymptoms(DiagnosisDTO diagnosisDTO, Patient patient, boolean onlyOne) {
        Diagnosis diagnosis = new Diagnosis();
        DiseaseFoundList diseaseFound = new DiseaseFoundList();

        addSymptomsToDiagnosis(diagnosis, diagnosisDTO.getSymptoms());

        diagnosis.setDateCreated(new Date());
        diagnosis.setPatient(patient);

        kieSession.getAgenda().getAgendaGroup("diseases").setFocus();
        kieSession.insert(diseaseFound);
        kieSession.insert(diseaseService);
        kieSession.insert(diagnosisService);
        kieSession.insert(diagnosis);
        diseaseFound.setOnlyOne(onlyOne);

        System.out.println(kieSession.fireAllRules());

        if(diseaseFound.getDiseases().size() > 0)
            diseaseFound.getDiseases().forEach(d -> System.out.println(d.getDisease().getName() + "  " + d.getWeight()));


        return new DiseaseFoundListDTO(diseaseFound);
    }

    private void addSymptomsToDiagnosis(Diagnosis diagnosis, List<SymptomDTO> symptoms) {
        List<Symptom> s = new ArrayList<>();
        symptoms.forEach(symptomDTO -> s.add(symptomDTO.getValue() != null ?
                symptomService.findByNameAndValueGreaterThan(symptomDTO.getName(), symptomDTO.getValue()) :
                symptomService.findByName(symptomDTO.getName())));

        diagnosis.setSymptoms(s);
    }
}
