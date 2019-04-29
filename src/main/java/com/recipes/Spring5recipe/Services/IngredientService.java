package com.recipes.Spring5recipe.Services;

import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.model.Ingredient;

public interface IngredientService extends CrudInterface<Ingredient, Long> {

    IngredientCommand findIngredientCommandById(Long id);

    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);

    IngredientCommand saveIngredientCommandForARecipe(IngredientCommand ingredientCommand);
}
