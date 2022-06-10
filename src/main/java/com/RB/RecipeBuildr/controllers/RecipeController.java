package com.RB.RecipeBuildr.controllers;

import com.RB.RecipeBuildr.models.Ingredient;
import com.RB.RecipeBuildr.models.Recipe;
import com.RB.RecipeBuildr.storage.HashtagStorage;
import com.RB.RecipeBuildr.storage.IngredStorage;
import com.RB.RecipeBuildr.storage.RecipeStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

    @RequestMapping("/all-recipes")
    public String allRecipes(Model model){
        model.addAttribute("allRecipes",recipeStorage.retrieveAll());
        return "Main-Recipe-Template";
    }

    @RequestMapping("/recipe/{id}")
    public String findRecipe(Model model, @PathVariable Long id){
        Recipe found = recipeStorage.findRecipe(id).get();
        model.addAttribute("recipe",found);

        //These shouldn't be needed
        model.addAttribute("ingredients",found.getIngredients());
        model.addAttribute("hashtags",found.getHashtags());

        return "Single-Recipe-Template";
    }

    @RequestMapping("/vegan-recipes")
    public String veganRecipes(Model model){
        model.addAttribute("veganRecipes",recipeStorage.retrieveVegan());
        return "Vegan-Recipe-Template";
    }

    @RequestMapping("/vegetarian-recipes")
    public String vegetRecipes(Model model){
        model.addAttribute("vegetRecipes",recipeStorage.retrieveVeget());
        return "Veget-Recipe-Template";
    }

    @RequestMapping("/new-ingred")
    public String addNewIngred(Model model){


        return "Add-Ingredient-Template";
    }

    @PostMapping("/add")
    public String addIngred(Model model, @RequestParam String inName, @RequestParam String inPic){
        Ingredient x = new Ingredient(inName,inPic);
        ingredStorage.saveIngred(x);

        return "Add-Ingredient-Template";
    }

//    @PostMapping("/person")
//    public String addPerson(Model model, @RequestParam String perName, @RequestParam int perAge, @RequestParam String perJob) { //indicates the argument should be retrieved from the model.
//        IdCard idCard = new IdCard(perJob);
//        idCardRepo.save(idCard);
//        Person x = new Person(perName,perAge,idCard);
//        personRepo.createPerson(x);
//
//        model.addAttribute("people", personRepo.getAllPersons());
//        return "result";
//    }
}
