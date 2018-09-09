package rs.ac.uns.ftn.sbz.projekat.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.sbz.projekat.model.Symptom;
import rs.ac.uns.ftn.sbz.projekat.service.SymptomService;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.SymptomDTO;


@RestController
@RequestMapping(value = "/api/simptom")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @PostMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity add(@RequestBody SymptomDTO symptomDTO) {
        return new ResponseEntity<>(this.symptomService.add(symptomDTO) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getAll() {
        return new ResponseEntity<>(symptomService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity delete(@RequestParam String name){
        return new ResponseEntity(this.symptomService.remove(name)? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
