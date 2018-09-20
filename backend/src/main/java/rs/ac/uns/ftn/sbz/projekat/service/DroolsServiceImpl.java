package rs.ac.uns.ftn.sbz.projekat.service;
import org.kie.api.definition.rule.All;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.*;
import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFound;
import rs.ac.uns.ftn.sbz.projekat.model.drools.DiseaseFoundList;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.*;

import java.text.SimpleDateFormat;
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
    private PatientService patientService;

    @Autowired
    private RemedyService remedyService;

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

        if(diseaseFound.getDiseases().size() > 0) {
            this.diagnosisService.save(diagnosis);
        }

        return new DiseaseFoundListDTO(diseaseFound);
    }

    @Override
    public DiagnosisDTO getDisease(DiagnosisDTO diagnosisDTO) {
        Patient patient = this.patientService.findByJmbg(diagnosisDTO.getJmbg());
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
        diseaseFound.setOnlyOne(true);

        System.out.println(kieSession.fireAllRules());

        if(diseaseFound.getDiseases().size() > 0) {
            diagnosis.setDisease(diseaseFound.getDiseases().get(0).getDisease());
            this.diagnosisService.save(diagnosis);
            diagnosisDTO.setId(diagnosis.getId());
            diagnosisDTO.setDisease(diagnosis.getDisease().getName());
            diagnosisDTO.setDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(diagnosis.getDateCreated()));
            patient.getDiagnoses().add(diagnosis);
            this.patientService.save(patient);
            return diagnosisDTO;
        }

        return  null;
    }

    @Override
    public DiagnosisDTO personalDiagnosis(DiagnosisDTO diagnosisDTO) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDateCreated(new Date());
        System.out.println(diagnosisDTO.toString());
        Patient patient = this.patientService.findByJmbg(diagnosisDTO.getJmbg());
        if(patient == null)
            return null;

        Disease disease = this.diseaseService.findByName(diagnosisDTO.getDisease());

        if(disease == null)
            return null;


        diagnosis.setPatient(patient);
        diagnosis.setDisease(disease);
        addSymptomsToDiagnosis(diagnosis, diagnosisDTO.getSymptoms());
        diagnosisService.save(diagnosis);
        patient.getDiagnoses().add(diagnosis);
        patientService.save(patient);
        diagnosisDTO.setDate( new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
        diagnosisDTO.setId(diagnosis.getId());

        return diagnosisDTO;
    }

    @Override
    public DiseaseDTO getSymptomsByDisease(String name) {
        DiseaseDTO disease = new DiseaseDTO();
        disease.setName(name);
        kieSession.insert(disease);
        kieSession.insert(this.symptomService);
        kieSession.getAgenda().getAgendaGroup("symptoms").setFocus();
        System.out.println(kieSession.fireAllRules());
        kieSession.destroy();
        return disease;
    }

    @Override
    public AllergyListDTO allergies(Long diagnosisId) {
        Diagnosis diagnosis = this.diagnosisService.findOne(diagnosisId);
        if(diagnosis == null)
            return null;

        AllergyListDTO list = new AllergyListDTO();

        kieSession.insert(diagnosis);
        kieSession.insert(diagnosis.getPatient());
        kieSession.insert(list);
        kieSession.getAgenda().getAgendaGroup("allergies").setFocus();
        System.out.println(kieSession.fireAllRules());

        kieSession.destroy();
        return list;
    }

    @Override
    public PatientListDTO chronics() {
        PatientListDTO patientListDTO = new PatientListDTO();

        List<Patient> patients = this.patientService.findAllFromDB();
        for(Patient patient : patients)
            kieSession.insert(patient);

        List<Disease> diseases = this.diseaseService.findAllFromDB();
        for(Disease disease : diseases)
            kieSession.insert(disease);

        kieSession.getAgenda().getAgendaGroup("chronical").setFocus();
        System.out.println(kieSession.fireAllRules());
        kieSession.destroy();
        return patientListDTO;
    }

    @Override
    public PatientListDTO addictions() {
        PatientListDTO patientListDTO = new PatientListDTO();

        List<Patient> patients = this.patientService.findAllFromDB();
        for(Patient patient : patients)
            kieSession.insert(patient);

        List<Disease> diseases = this.diseaseService.findAllFromDB();
        for(Disease disease : diseases)
            kieSession.insert(disease);

        List<Remedy> remedies = remedyService.findAll();
        for(Remedy remedy : remedies)
            kieSession.insert(remedy);

        kieSession.insert(patientListDTO);
        kieSession.getAgenda().getAgendaGroup("addictions").setFocus();
        kieSession.fireAllRules();
        return  patientListDTO;
    }

    @Override
    public PatientListDTO lowImmunity() {
        PatientListDTO patientListDTO = new PatientListDTO();

        List<Patient> patients = this.patientService.findAllFromDB();
        for(Patient patient : patients)
            kieSession.insert(patient);

        kieSession.insert(patientListDTO);
        kieSession.getAgenda().getAgendaGroup("imunity").setFocus();
        kieSession.fireAllRules();
        kieSession.destroy();
        return patientListDTO;
    }

    private void addSymptomsToDiagnosis(Diagnosis diagnosis, List<SymptomDTO> symptoms) {
        List<Symptom> s = new ArrayList<>();
        symptoms.forEach(symptomDTO -> s.add(symptomDTO.getValue() != null ?
                symptomService.findByNameAndValueGreaterThan(symptomDTO.getName(), symptomDTO.getValue()) :
                symptomService.findByName(symptomDTO.getName())));

        diagnosis.setSymptoms(s);
    }
}
