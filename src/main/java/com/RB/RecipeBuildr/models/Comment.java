package com.RB.RecipeBuildr.models;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.List;

@Embeddable
public class Comment {
    @Id
    @GeneratedValue
    Long id;
    String author;
    String comment;
    Collection<Recipe> recipeComment;

    public Comment(String comment, String author, Recipe...recipes){
        this.author = author;
        this.comment = comment;
        this.recipeComment = List.of(recipes);
    }

    public Comment(){}

    public String getComment() {
        return comment;
    }
}
