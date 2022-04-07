package com.RB.RecipeBuildr.storage;

import com.RB.RecipeBuildr.models.Recipe;
import org.springframework.stereotype.Service;

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
}
