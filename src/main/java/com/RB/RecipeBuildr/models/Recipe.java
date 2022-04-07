package com.RB.RecipeBuildr.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    Long id;
    String imgUrl;
    boolean isVegan;
    boolean isVegetarian;
    @ManyToMany
    Collection<Ingredient> ingredients;
    @ManyToMany(mappedBy = "recipes")
    Collection<Hashtag> hashtags;
    @Embedded
    Collection<Comment> comments;
    ArrayList<String> steps;

    public Recipe(String imgUrl, boolean isVegan, boolean isVegetarian, Ingredient...ingredients) {
        this.imgUrl = imgUrl;
        this.isVegan = isVegan;
        this.isVegetarian = isVegetarian;
        this.ingredients = List.of(ingredients);
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

    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
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
