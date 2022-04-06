package com.RB.RecipeBuildr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String imgUrl;

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

}
