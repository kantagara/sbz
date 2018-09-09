package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Remedy;
import rs.ac.uns.ftn.sbz.projekat.model.Ingredient;
import rs.ac.uns.ftn.sbz.projekat.repository.RemedyRepository;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.LekDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemedyServiceImpl implements RemedyService {

    @Autowired
    private RemedyRepository remedyRepository;

    @Autowired
    private IngredientService sastojakService;

    @Override
    public Remedy findOne(Long id) {
        return this.remedyRepository.findOne(id);
    }

    @Override
    public Remedy save(Remedy lek) {
        return this.remedyRepository.save(lek);
    }


    @Override
    public void remove(Remedy lek) {
        this.remedyRepository.delete(lek.getId());
    }

    @Override
    public List<Remedy> findAll(){
        return this.remedyRepository.findAll();
    }

    @Override
    public Remedy findByNaziv(String naziv){
        return this.remedyRepository.findByName(naziv);
    }

    @Override
    public void alter(LekDTO lekDTO) {
        Remedy lek = findByNaziv(lekDTO.getNaziv());
        lek.setRemedyType(lekDTO.getRemedyType());

        List<Ingredient> zaBrisanje = new ArrayList<>();

        for (Ingredient sastojak: lek.getSastojci()){
            boolean exists = false;
            for(String naziv_sastojka: lekDTO.getSastojci()){
                if(sastojak.getName().equals(naziv_sastojka))
                    exists = true;
            }
            if(!exists) {
                zaBrisanje.add(this.sastojakService.findByNaziv(sastojak.getName()));
            }
        }

        for(Ingredient sastojak: zaBrisanje){
            this.sastojakService.remove(sastojak);
            lek.getSastojci().remove(sastojak);
        }

        for(String naziv: lekDTO.getSastojci()){
            Ingredient sastojak = this.sastojakService.findByNaziv(naziv);
            if(sastojak == null){
                Ingredient novi = new Ingredient(naziv);
                novi = this.sastojakService.save(novi);
                lek.getSastojci().add(novi);
            }
            if(!lek.getSastojci().contains(sastojak))
                lek.getSastojci().add(sastojak);
        }

        save(lek);
    }

    @Override
    public boolean add(LekDTO lekDTO) {
        Remedy postoji = findByNaziv(lekDTO.getNaziv());

        if(postoji != null)
            return false;

        List<Ingredient> sastojciLeka = new ArrayList<>();

        for (String sas : lekDTO.getSastojci()){
            Ingredient sastojak = this.sastojakService.findByNaziv(sas);
            if(sastojak == null)
                sastojak = this.sastojakService.save(new Ingredient(sas));
            sastojciLeka.add(sastojak);
        }

        Remedy lek = new Remedy(lekDTO.getRemedyType(), lekDTO.getNaziv(), sastojciLeka);

        lek = save(lek);
        for(Ingredient sastojak: sastojciLeka){
            this.sastojakService.save(sastojak);
        }

        return true;
    }

    @Override
    public List<LekDTO> getAll() {
        List<Remedy> lekovi = findAll();
        List<LekDTO> dtos = new ArrayList<>();

        for(Remedy l: lekovi){
            List<String> sastojci = new ArrayList<>();
            for(Ingredient sastojak: l.getSastojci())
                sastojci.add(sastojak.getName());
            dtos.add(new LekDTO(l.getName(), sastojci, l.getRemedyType()));
        }

        return dtos;
    }

    @Override
    public List<String> getAllIngridients() {
        List<Ingredient> sastojaci = this.sastojakService.findAll();
        List<String> nazivi_sastojaka = new ArrayList<>();
        for(Ingredient sastojak: sastojaci){
            nazivi_sastojaka.add(sastojak.getName());
        }

        return nazivi_sastojaka;
    }
}
