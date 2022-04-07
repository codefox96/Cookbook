package com.RB.RecipeBuildr.storage;

import com.RB.RecipeBuildr.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepo extends CrudRepository<Recipe,Long> {
}
