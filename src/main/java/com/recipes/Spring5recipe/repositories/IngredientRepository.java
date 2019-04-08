package com.recipes.Spring5recipe.repositories;

import com.recipes.Spring5recipe.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
}
