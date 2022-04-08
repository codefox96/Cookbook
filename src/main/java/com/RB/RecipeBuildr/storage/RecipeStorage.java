package com.RB.RecipeBuildr.storage;

import com.RB.RecipeBuildr.models.Hashtag;
import com.RB.RecipeBuildr.models.Ingredient;
import com.RB.RecipeBuildr.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class RecipeStorage {
    RecipeRepo recipeRepo;
    HashtagRepo hashRepo;
    IngredientRepo ingredRepo;

    public RecipeStorage(RecipeRepo recipeRepo, HashtagRepo hashRepo, IngredientRepo ingredRepo) {
        this.recipeRepo = recipeRepo;
        this.hashRepo = hashRepo;
        this.ingredRepo = ingredRepo;
    }

    public void saveRecipe(Recipe x){
        recipeRepo.save(x);
    }

    public Optional<Recipe> findRecipe(Long id){
        return recipeRepo.findById(id);
    }

    public Iterable<Ingredient> findIngredients(Recipe x){
        return x.getIngredients();
    }

    public Iterable<Hashtag> findHashtags(Recipe x){
        return x.getHashtags();
    }

    public Iterable<Recipe> retrieveAll(){
        return recipeRepo.findAll();
    }

    public Iterable<Recipe> retrieveVegan(){
       ArrayList<Recipe> veganFood = new ArrayList<>();

       for(Recipe x:retrieveAll()){
           if (x.isVegan()) veganFood.add(x);
       }

       return veganFood;
    }

    public Iterable<Recipe> retrieveVeget(){
        ArrayList<Recipe> vegetFood = new ArrayList<>();

        for(Recipe x:retrieveAll()){
            if (x.isVegetarian()) vegetFood.add(x);
        }

        return vegetFood;
    }
}
