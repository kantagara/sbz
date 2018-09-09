package rs.ac.uns.ftn.sbz.projekat.web.DTOs;

import rs.ac.uns.ftn.sbz.projekat.model.Remedy;
import rs.ac.uns.ftn.sbz.projekat.model.RemedyType;

import java.util.ArrayList;
import java.util.List;

public class RemedyDTO {

    private String name;
    private List<String> ingredients;
    private RemedyType remedyType;

    public RemedyDTO(){
        this.ingredients = new ArrayList<>();
    }

    public RemedyDTO(String name, List<String> ingredients, RemedyType remedyType) {
        this.name = name;
        this.ingredients = ingredients;
        this.remedyType = remedyType;
    }

    public RemedyDTO(Remedy remedy){
        this.name = remedy.getName();
        this.ingredients = new ArrayList<>();
        remedy.getIngredients().forEach(i -> ingredients.add(i.getName()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public RemedyType getRemedyType() {
        return remedyType;
    }

    public void setRemedyType(RemedyType remedyType) {
        this.remedyType = remedyType;
    }
}
