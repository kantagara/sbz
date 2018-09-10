package rs.ac.uns.ftn.sbz.projekat.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.sbz.projekat.model.Patient;
import rs.ac.uns.ftn.sbz.projekat.service.DroolsService;
import rs.ac.uns.ftn.sbz.projekat.service.PatientService;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiagnosisDTO;

@RestController
@RequestMapping("/api/drools")
public class DroolsController {

    @Autowired
    DroolsService droolsService;

    @Autowired
    PatientService patientService;


    @PostMapping
            (value = "/disease",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity disease(@RequestBody DiagnosisDTO diagnosis){

        Patient patient = patientService.findByJmbg(diagnosis.getJmbg());
        if(patient == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(this.droolsService.getDiseaseBySymptoms(diagnosis, patient, true), HttpStatus.OK);
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


}
