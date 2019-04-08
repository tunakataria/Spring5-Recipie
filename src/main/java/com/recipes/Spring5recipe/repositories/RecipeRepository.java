package com.recipes.Spring5recipe.repositories;

import com.recipes.Spring5recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {


}
