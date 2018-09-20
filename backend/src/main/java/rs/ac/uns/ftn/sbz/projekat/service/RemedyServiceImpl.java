package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Account;
import rs.ac.uns.ftn.sbz.projekat.model.Diagnosis;
import rs.ac.uns.ftn.sbz.projekat.model.Remedy;
import rs.ac.uns.ftn.sbz.projekat.model.Ingredient;
import rs.ac.uns.ftn.sbz.projekat.repository.RemedyRepository;
import rs.ac.uns.ftn.sbz.projekat.security.JWTUtils;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.PrescribedRemedyDTO;
import rs.ac.uns.ftn.sbz.projekat.web.DTOs.RemedyDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemedyServiceImpl implements RemedyService {

    @Autowired
    private RemedyRepository remedyRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private DiagnosisService diagnosisService;


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
    public Remedy findByName(String name){
        return this.remedyRepository.findByName(name);
    }

    @Override
    public void change(RemedyDTO remedyDTO) {
        Remedy remedy = findByName(remedyDTO.getName());
        remedy.setRemedyType(remedyDTO.getRemedyType());

        List<Ingredient> ingredients = new ArrayList<>();

        for (Ingredient ingredient: remedy.getIngredients()){
            boolean exists = false;
            for(String name: remedyDTO.getIngredients()){
                if(ingredient.getName().equals(name))
                    exists = true;
            }
            if(!exists) {
                ingredients.add(this.ingredientService.findByNaziv(ingredient.getName()));
            }
        }

        for(Ingredient ing: ingredients){
            remedy.getIngredients().remove(ing);
            this.ingredientService.remove(ing);
        }

        for(String name: remedyDTO.getIngredients()){
            Ingredient ingredient = this.ingredientService.findByNaziv(name);
            if(ingredient == null){
                Ingredient ing = new Ingredient(name);
                ing = this.ingredientService.save(ing);
                remedy.getIngredients().add(ing);
                ingredientService.save(ing);
            }
            else if(!remedy.getIngredients().contains(ingredient))
                remedy.getIngredients().add(ingredient);
        }

        save(remedy);
    }

    @Override
    public boolean add(RemedyDTO remedyDTO) {
        Remedy exists = findByName(remedyDTO.getName());

        if(exists != null)
            return false;

        List<Ingredient> ingredients = new ArrayList<>();

        for (String sas : remedyDTO.getIngredients()){
            Ingredient ingredient = this.ingredientService.findByNaziv(sas);
            if(ingredient == null)
                ingredient = this.ingredientService.save(new Ingredient(sas));
            ingredients.add(ingredient);
        }

        Remedy remedy = new Remedy(remedyDTO.getRemedyType(), remedyDTO.getName(), ingredients);

        save(remedy);
        for(Ingredient ingredient: ingredients){
            this.ingredientService.save(ingredient);
        }

        return true;
    }

    @Override
    public List<RemedyDTO> getAll() {
        List<Remedy> remedies = findAll();
        List<RemedyDTO> dtos = new ArrayList<>();

        for(Remedy l: remedies){
            List<String> ingredients = new ArrayList<>();
            for(Ingredient ing: l.getIngredients())
                ingredients.add(ing.getName());
            dtos.add(new RemedyDTO(l.getName(), ingredients, l.getRemedyType()));
        }

        return dtos;
    }

    @Override
    public List<String> getAllIngredients() {
        List<Ingredient> ingredients = this.ingredientService.findAll();
        List<String> names = new ArrayList<>();
        for(Ingredient name: ingredients){
            names.add(name.getName());
        }

        return names;
    }

    @Override
    public boolean prescribe(String token, PrescribedRemedyDTO prescribedRemedyDTO) {

        Account account = this.accountService.findByUsername(jwtUtils.getUsernameFromToken(token));
        System.out.println("AA");
        if(account == null) return false;

        Diagnosis diagnosis = diagnosisService.findOne(prescribedRemedyDTO.getDiagnosisId());
        System.out.println("BBB");
        System.out.println(prescribedRemedyDTO);
        if(diagnosis == null) return false;
        System.out.println("CCCCC");
        for (int i = 0; i < prescribedRemedyDTO.getRemedies().size(); i++) {
            RemedyDTO dto = prescribedRemedyDTO.getRemedies().get(i);
            Remedy remedy = remedyRepository.findByName(dto.getName());
            if(remedy == null) return false;

            diagnosis.getTherapy().add(remedy);
        }

        this.diagnosisService.save(diagnosis);

        return true;
    }
}
