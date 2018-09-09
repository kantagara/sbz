package rs.ac.uns.ftn.sbz.projekat.service;


import rs.ac.uns.ftn.sbz.projekat.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient save(Ingredient Ingredient);

    Ingredient findOne(Long id);

    List<Ingredient> findAll();

    void remove(Ingredient Ingredient);

    Ingredient findByNaziv(String naziv);
}
