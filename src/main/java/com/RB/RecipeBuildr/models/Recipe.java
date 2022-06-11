package com.RB.RecipeBuildr.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String imgUrl;
    private boolean isVegan;
    private boolean isVegetarian;
    @ManyToMany
    private Collection<Ingredient> ingredients;
    @ManyToMany(mappedBy = "recipes")
    private Collection<Hashtag> hashtags;
    @OneToMany
    private Collection<Comment> comments;
    @Lob
    private ArrayList<String> steps;

    public Recipe(String name, String imgUrl, boolean isVegan, boolean isVegetarian, Ingredient... ingredients) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.isVegan = isVegan;
        this.isVegetarian = isVegetarian;
        this.ingredients = List.of(ingredients);
        this.hashtags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public Recipe(){}

    public void addStep(String...step){
        for(String x:step){
            steps.add(x);
        }
    }

    public void addHashtag(Hashtag...added){
        for(Hashtag x:added){
            hashtags.add(x);
        }
    }

    public void addComment(Comment...comment){
        for(Comment x:comment){
            comments.add(x);
        }
    }

    public void addIngred(Ingredient...ingreds){
        for(Ingredient x:ingreds){
            ingredients.add(x);
        }
    }

    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public Collection<String> getSteps() {
        return steps;
    }

}
