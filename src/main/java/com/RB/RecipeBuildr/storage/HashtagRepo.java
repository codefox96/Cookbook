package com.RB.RecipeBuildr.storage;

import com.RB.RecipeBuildr.models.Hashtag;
import org.springframework.data.repository.CrudRepository;

public interface HashtagRepo extends CrudRepository<Hashtag,Long> {
}
