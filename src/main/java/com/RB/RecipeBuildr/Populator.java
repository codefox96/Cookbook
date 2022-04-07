package com.RB.RecipeBuildr;

import com.RB.RecipeBuildr.models.Hashtag;
import com.RB.RecipeBuildr.models.Ingredient;
import com.RB.RecipeBuildr.models.Recipe;
import com.RB.RecipeBuildr.storage.HashtagStorage;
import com.RB.RecipeBuildr.storage.IngredStorage;
import com.RB.RecipeBuildr.storage.RecipeStorage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    IngredStorage ingredStorage;
    RecipeStorage recipeStorage;
    HashtagStorage hashStorage;

    public Populator(IngredStorage ingredStorage, RecipeStorage recipeStorage, HashtagStorage hashStorage) {
        this.ingredStorage = ingredStorage;
        this.recipeStorage = recipeStorage;
        this.hashStorage = hashStorage;
    }

    @Override
    public void run(String... args) throws Exception {

        Ingredient artichoke = new Ingredient("Artichoke","artImg");
        Ingredient carrot = new Ingredient("Carrot","carImg");
        ingredStorage.saveIngred(artichoke,carrot);

        Recipe artichokeSoup = new Recipe("Artichoke Soup",false,false,artichoke,carrot);
        recipeStorage.saveRecipe(artichokeSoup);

        Hashtag hashOne = new Hashtag("Wow!",artichokeSoup);
        hashStorage.saveHashtag(hashOne);

    }
}
