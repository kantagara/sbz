package rs.ac.uns.ftn.sbz.projekat.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.sbz.projekat.service.DiseaseService;
import rs.ac.uns.ftn.sbz.projekat.service.SymptomService;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.DiseaseDTO;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/bolest")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;


    @PostMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity create(@RequestBody DiseaseDTO diseaseDTO) {
        return new ResponseEntity<>(this.diseaseService.add(diseaseDTO) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity findAll() {
        return new ResponseEntity<>(diseaseService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity delete(@RequestParam String name){

        return new ResponseEntity(this.diseaseService.remove(name) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PutMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity update(@RequestBody DiseaseDTO diseaseDTO) {

        this.diseaseService.update(diseaseDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
