package com.RB.RecipeBuildr.storage;

import com.RB.RecipeBuildr.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment,Long> {
}
