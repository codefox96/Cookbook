package com.RB.RecipeBuildr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.List;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    Long id;
    String name;
    Collection<Recipe> recipes;

    public Hashtag(String name, Recipe...recipes) {
        this.name = name;
        this.recipes = List.of(recipes);
    }

    public Hashtag(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Recipe> getRecipes() {
        return recipes;
    }
}
