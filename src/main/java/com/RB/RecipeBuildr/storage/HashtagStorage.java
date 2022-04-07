package com.RB.RecipeBuildr.storage;

import com.RB.RecipeBuildr.models.Hashtag;
import org.springframework.stereotype.Service;

@Service
public class HashtagStorage {
    HashtagRepo hashRepo;
    RecipeRepo recipeRepo;

    public HashtagStorage(HashtagRepo hashRepo, RecipeRepo recipeRepo) {
        this.hashRepo = hashRepo;
        this.recipeRepo = recipeRepo;
    }

    public void saveHashtag(Hashtag x){
        hashRepo.save(x);
    }
}
