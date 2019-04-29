package com.recipes.Spring5recipe.Services;


import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.command.RecipeCommand;
import com.recipes.Spring5recipe.model.Recipe;

public interface RecipeService extends CrudInterface<Recipe,Long> {

     RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

     RecipeCommand findRecipeCommandById(Long id);

     IngredientCommand findIngredientCommandByIdForRecipe(Long recipeId, Long ingredientId);

}
