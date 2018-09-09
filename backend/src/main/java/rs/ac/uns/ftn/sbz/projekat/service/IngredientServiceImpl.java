package rs.ac.uns.ftn.sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sbz.projekat.model.Ingredient;
import rs.ac.uns.ftn.sbz.projekat.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;


    @Override
    public Ingredient findOne(Long id) {
        return this.ingredientRepository.findOne(id);
    }

    @Override
    public Ingredient save(Ingredient Ingredient) {
        return this.ingredientRepository.save(Ingredient);
    }


    @Override
    public void remove(Ingredient Ingredient) {
        this.ingredientRepository.delete(Ingredient.getId());
    }

    @Override
    public List<Ingredient> findAll(){
        return this.ingredientRepository.findAll();
    }

    @Override
    public Ingredient findByNaziv(String naziv){
        return this.ingredientRepository.findByName(naziv);
    }
}
