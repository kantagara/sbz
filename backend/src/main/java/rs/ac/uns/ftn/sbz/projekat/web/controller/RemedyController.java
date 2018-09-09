package rs.ac.uns.ftn.sbz.projekat.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.sbz.projekat.model.Remedy;
import rs.ac.uns.ftn.sbz.projekat.service.RemedyService;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.LekDTO;

@RestController
@RequestMapping(value = "/api/lek")
public class RemedyController {

    @Autowired
    private RemedyService remedyService;

    @PostMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity addNew(@RequestBody LekDTO lekDTO) {

        return new ResponseEntity<>(lekDTO,
                !this.remedyService.add(lekDTO) ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @GetMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getAll() {
        return new ResponseEntity<>(this.remedyService.getAll(), HttpStatus.OK);
    }

    @GetMapping(
            value = "/ingredients",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity getAllIngredients() {

        return new ResponseEntity<>(remedyService.getAllIngridients(), HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity delete(@RequestParam String naziv){

        Remedy lek = this.remedyService.findByNaziv(naziv);
        if(lek == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        this.remedyService.remove(lek);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(
            value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity alter(@RequestBody LekDTO lekDTO) {

        this.remedyService.alter(lekDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
