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
        Ingredient chickenThigh = new Ingredient("Chicken Thigh","x");
        Ingredient tomatoSauce = new Ingredient("Tomato Sauce","x");
        Ingredient onion= new Ingredient("Onion","x");
        Ingredient potato = new Ingredient("Potato","x");
        Ingredient chipotle = new Ingredient("Chipotle Pepper","");
        Ingredient arbol = new Ingredient("Chilli De Arbol","");
        Ingredient cream = new Ingredient("Heavy Creamer","");
        Ingredient butter = new Ingredient("Butter","");
        Ingredient egg = new Ingredient("Egg","x");
        Ingredient mayo = new Ingredient("Mayo","");
        Ingredient bread = new Ingredient("Bread","");
        Ingredient oilV = new Ingredient("Vegetable Oil","");
        Ingredient classified = new Ingredient("*Classified*","");
        ingredStorage.saveIngred(artichoke,carrot,chickenThigh,tomatoSauce,onion,potato,chipotle,arbol,cream,butter,egg,bread,mayo,oilV,classified);

        Comment commentOne = new Comment("Blahblahblah","Jordan");
        commRepo.save(commentOne);


        Recipe artichokeSoup = new Recipe("Artichoke Soup", "Artichoke Soup", false, false, artichoke, carrot);
        Recipe tomatoChicken = new Recipe("Creamy Tomato Chicken","x",false,false,chickenThigh,tomatoSauce,onion,potato,chipotle,arbol,cream,butter);
        tomatoChicken.addStep("Bring pot to medium heat and coat the base with butter","Place your seasoned or brined chicken skin side up, you should hear it sizzle! Then cook until the bottom is nicely browned",
                              "Remove chicken from pan and toss in your chopped onions and use the liquid they produce to get the browned chicken spots off the bottom of your pot; this is where the flavor is!!",
                              "Lower your cooking temp to medium low and throw in your tomato sauce and heavy cream then stir until the resulting liquid is a nice shade of light orange","Add chilli peppers and chicken",
                              "Skim any oil that rises to the top","Let the mixture simmer for 1 hour or until chicken is at desired softness");
        Recipe eggSandwich = new Recipe("The Perfect Egg Sandwich","",false,true,egg,mayo,oilV,bread);
        eggSandwich.addStep("Pour enough oil in a medium sized pot or pan for your eggs to swim in","Put the stove on a moderately high temp and wait until oil is screaming hot",
                            "In the mean time, spread some mayo on a slice of bread and salt to taste","Crack 2 eggs in a cup then pour them into the hot oil. Ensure that the eggs are in he center while cooking so all sides get browned",
                            "Cook until the bottom of the egg is brown and bubbly with the yolk cooked on the bottom but runny on the top and DO NOT FLIP!","remove eggs from the oil and place on top of your mayoed bread."+
                            "Break the yolk and spread it over the top of the egg","Top with another slice of bread and enjoy!");
        Recipe ribs = new Recipe("Jordan's Secret Ribs","",false,false,classified);
        ribs.addStep("Wash ribs and remove silver skin to prevent ribs from arching while cooking","Brine the ribs in *MIND YOUR BUSINESS* for at least *NOT YOUR CONCERN* hours","Place coals and *REDACTED* wood chunks in your grill.",
                      "Remove *DON'T WORRY ABOUT IT* from your brine to place on top of thin spots of ribs to prevent dry out","Light grill and place ribs *DIRECTLY OVER THE FIRE WITH ALL VENTS OPEN* for *SOME* hours",
                      "Remove from grill and *MIND YOUR DAMN BUSINESS!!! D:<*");

        artichokeSoup.addComment(commentOne);
        artichokeSoup.addStep("Make","Eat");
        recipeStorage.saveRecipe(artichokeSoup,tomatoChicken,eggSandwich,ribs);

        Hashtag hashOne = new Hashtag("Wow!",artichokeSoup);
        hashStorage.saveHashtag(hashOne);



        artichokeSoup.addHashtag(hashOne);


    }
}
