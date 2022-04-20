package com.RB.RecipeBuildr;

import com.RB.RecipeBuildr.models.Comment;
import com.RB.RecipeBuildr.models.Hashtag;
import com.RB.RecipeBuildr.models.Ingredient;
import com.RB.RecipeBuildr.models.Recipe;
import com.RB.RecipeBuildr.storage.CommentRepo;
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
    CommentRepo commRepo;

    public Populator(IngredStorage ingredStorage, RecipeStorage recipeStorage, HashtagStorage hashStorage,CommentRepo commRepo) {
        this.ingredStorage = ingredStorage;
        this.recipeStorage = recipeStorage;
        this.hashStorage = hashStorage;
        this.commRepo = commRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Ingredient artichoke = new Ingredient("Artichoke","artImg");
        Ingredient carrot = new Ingredient("Carrot","carImg");
        ingredStorage.saveIngred(artichoke,carrot);

        Comment commentOne = new Comment("Blahblahblah","Jordan");
        commRepo.save(commentOne);


        Recipe artichokeSoup = new Recipe("Artichoke Soup", "Artichoke Soup", false, false, artichoke, carrot);

        artichokeSoup.addComment(commentOne);
        artichokeSoup.addStep("Make","Eat");
        recipeStorage.saveRecipe(artichokeSoup);

        Hashtag hashOne = new Hashtag("Wow!",artichokeSoup);
        hashStorage.saveHashtag(hashOne);



        artichokeSoup.addHashtag(hashOne);


    }
}
