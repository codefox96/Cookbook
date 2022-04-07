package com.RB.RecipeBuildr.storage;

import com.RB.RecipeBuildr.models.Ingredient;
import org.springframework.stereotype.Service;

@Service
public class IngredStorage {

    IngredientRepo ingredRepo;
    RecipeRepo recipeRepo;

    public IngredStorage(IngredientRepo ingredRepo, RecipeRepo recipeRepo) {
        this.ingredRepo = ingredRepo;
        this.recipeRepo = recipeRepo;
    }

    public void saveIngred(Ingredient x){
        ingredRepo.save(x);
    }


}
