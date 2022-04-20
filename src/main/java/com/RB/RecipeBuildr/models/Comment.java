package com.RB.RecipeBuildr.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    Long id;
    String author;
    String comment;
    @ManyToOne
    Recipe recipe;
//    Collection<Recipe> recipeComment;

    public Comment(String comment, String author){
        this.author = author;
        this.comment = comment;
    }

    public Comment(){}

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
