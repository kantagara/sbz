package rs.ac.uns.ftn.sbz.projekat.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;
import rs.ac.uns.ftn.sbz.projekat.model.Patient;
import rs.ac.uns.ftn.sbz.projekat.service.DroolsService;
import rs.ac.uns.ftn.sbz.projekat.service.PatientService;
import rs.ac.uns.ftn.sbz.projekat.service.RemedyService;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/api/drools")
public class DroolsController {

    @Autowired
    DroolsService droolsService;

    @Autowired
    PatientService patientService;

    @Autowired
    RemedyService  remedyService;


    @PostMapping
            (value = "/disease",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity disease(@RequestBody DiagnosisDTO diagnosis){

        Patient patient = patientService.findByJmbg(diagnosis.getJmbg());
        if(patient == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(this.droolsService.getDisease(diagnosis), HttpStatus.OK);
    }

    @PostMapping
            (value = "/most_likely",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity diseaseByWeight(@RequestBody DiagnosisDTO diagnosis){

        Patient patient = patientService.findByJmbg(diagnosis.getJmbg());
        if(patient == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(this.droolsService.getDiseaseBySymptoms(diagnosis, patient, false), HttpStatus.OK);
    }

    @PostMapping
            (value = "/personal_diagnosis",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity personalDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO){
        Object a = this.droolsService.personalDiagnosis(diagnosisDTO);
        return new ResponseEntity<>(a, a == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);

    }

    @GetMapping(value = "/get_symptoms",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSymptoms(@RequestParam String name){

        DiseaseDTO diseaseDTO = this.droolsService.getSymptomsByDisease(name);

        if(diseaseDTO.getGeneral().size() == 0 && diseaseDTO.getSpecific().size() == 0)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(diseaseDTO, HttpStatus.OK);

    }

    @PostMapping(value = "/prescribe",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity prescribeRemedies(@RequestHeader("Authentication-Token") String token,
                                            @RequestBody PrescribedRemedyDTO prescribedRemedyDTO){
        System.out.println(token);
        System.out.println(prescribedRemedyDTO);

        return new ResponseEntity(this.remedyService.prescribe(token, prescribedRemedyDTO)
                ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/allergies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity checkAllergies(@RequestParam Long diagnosisId){

        AllergyListDTO allergies = this. droolsService.allergies(diagnosisId);
        if(allergies == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return  new ResponseEntity<>(allergies, HttpStatus.OK);

    }

    @GetMapping(value = "/chronical", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity checkChronical(){

        PatientListDTO allergies = this. droolsService.chronics();
        if(allergies.getPatients().size() == 0) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return  new ResponseEntity<>(allergies, HttpStatus.OK);

    }


    @GetMapping(value = "/addiction", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity checkAddiciton(){

        PatientListDTO allergies = this. droolsService.addictions();
        if(allergies.getPatients().size() == 0) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return  new ResponseEntity<>(allergies, HttpStatus.OK);

    }

    @GetMapping(value = "/immunity", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity checkImmunity(){

        PatientListDTO allergies = this. droolsService.lowImmunity();
        if(allergies.getPatients().size() == 0) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return  new ResponseEntity<>(allergies, HttpStatus.OK);

    }



}
