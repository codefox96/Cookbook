package com.RB.RecipeBuildr.storage;

import com.RB.RecipeBuildr.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepo extends CrudRepository<Ingredient, Long> {
}
