package com.RB.RecipeBuildr.controllers;

import com.RB.RecipeBuildr.storage.HashtagStorage;
import com.RB.RecipeBuildr.storage.IngredStorage;
import com.RB.RecipeBuildr.storage.RecipeStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {
    IngredStorage ingredStorage;
    RecipeStorage recipeStorage;
    HashtagStorage hashtagStorage;

    public RecipeController(IngredStorage ingredStorage, RecipeStorage recipeStorage, HashtagStorage hashtagStorage) {
        this.ingredStorage = ingredStorage;
        this.recipeStorage = recipeStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @RequestMapping("recipe/{id}")
    public String findRecipe(Model model, @PathVariable Long id){
        model.addAttribute(recipeStorage.findRecipe(id));
        //give back hashtags and ingredients

        return "Single-Recipe-Template";
    }


    @RequestMapping("all-recipes")
    public String allRecipes(Model model){
        model.addAttribute(recipeStorage.retrieveAll());
        return "Main-Recipe-Template";
    }

    @RequestMapping("vegan-recipies")
    public String veganRecipes(Model model){
        model.addAttribute(recipeStorage.retrieveVegan());
        return "Vegan-Recipe-Template";
    }

    @RequestMapping("vegetarian-recipes")
    public String vegetRecipes(Model model){
        model.addAttribute(recipeStorage.retrieveVeget());
        return "Veget-Recipe-Template";
    }
}
