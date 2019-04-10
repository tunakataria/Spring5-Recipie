package com.recipes.Spring5recipe.repositories;

import com.recipes.Spring5recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {


}
