package com.RB.RecipeBuildr.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @Lob
    String imgUrl;
    @ManyToMany(mappedBy = "ingredients")
    Collection<Recipe> recipes;

    public Ingredient(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public Ingredient(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Collection<Recipe> getRecipes() {
        return recipes;
    }
}
