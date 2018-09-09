package rs.ac.uns.ftn.sbz.projekat.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.sbz.projekat.model.*;
import rs.ac.uns.ftn.sbz.projekat.service.DiagnosisService;
import rs.ac.uns.ftn.sbz.projekat.service.IngredientService;
import rs.ac.uns.ftn.sbz.projekat.service.PatientService;
import rs.ac.uns.ftn.sbz.projekat.service.RemedyService;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiagnosisDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.PatientDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.SymptomDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private RemedyService remedyService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private DiagnosisService diagnosisService;

    @PostMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity create(@RequestBody PatientDTO patientDTO) {

        return new ResponseEntity<>(patientService.create(patientDTO) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getAll() {
        return new ResponseEntity<>(this.patientService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity delete(@RequestParam String jmbg){

        Patient patient = this.patientService.findByJmbg(jmbg);
        if(patient == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        this.patientService.remove(patient);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity update(@RequestBody PatientDTO patientDTO) {

        return new ResponseEntity<>(this.patientService.update(patientDTO) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping(
            value = "/jmbg",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getByJmbg(@RequestParam String jmbg) {
        return new ResponseEntity<>(new PatientDTO(this.patientService.findByJmbg(jmbg)),HttpStatus.OK);
    }


}
