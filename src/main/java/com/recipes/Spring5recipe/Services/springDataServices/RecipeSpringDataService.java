package com.recipes.Spring5recipe.Services.springDataServices;

import com.recipes.Spring5recipe.Services.RecipeService;
import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.command.RecipeCommand;
import com.recipes.Spring5recipe.converters.IngredientToIngredientCommand;
import com.recipes.Spring5recipe.converters.RecipeCommandToRecipe;
import com.recipes.Spring5recipe.converters.RecipeToRecipeCommand;
import com.recipes.Spring5recipe.model.Ingredient;
import com.recipes.Spring5recipe.model.Recipe;
import com.recipes.Spring5recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeSpringDataService implements RecipeService {

    RecipeRepository recipeRepository;
    RecipeCommandToRecipe recipeCommandToRecipe;
    RecipeToRecipeCommand recipeToRecipeCommand;
    IngredientToIngredientCommand ingredientToIngredientCommand;

    public RecipeSpringDataService(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public Recipe findById(Long aLong) {
        return recipeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Recipe save(Recipe object) {
        return recipeRepository.save(object);
    }

    @Override
    public Iterable<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        recipeRepository.deleteById(aLong);
    }

    @Override
    public Iterable<Recipe> findByName(String name) {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach($ -> recipes.add($));
        return recipes;
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand){
      Recipe Recipe =   recipeCommandToRecipe.convert(recipeCommand);
      Recipe savedRecipe = save(Recipe);
      return recipeToRecipeCommand.convert(savedRecipe);

    }

    @Override
    public RecipeCommand findRecipeCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    public IngredientCommand findIngredientCommandByIdForRecipe(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        final Recipe savedRecipe;

        final Ingredient ingredient;

        if (recipeOptional.isPresent()) {
            savedRecipe = recipeOptional.get();
            Optional<Ingredient> optionalIngredient = savedRecipe.getIngredients().stream().filter($ -> $.getId().equals(ingredientId)).findFirst();

            if (optionalIngredient.isPresent()) {
                ingredient = optionalIngredient.get();
                IngredientCommand detachedIngredient = ingredientToIngredientCommand.convert(ingredient);
                detachedIngredient.setRecipeId(ingredient.getRecipe().getId());
                return detachedIngredient;
            } else {
                return null;
            }

        } else {
            return null;
        }

    }
}
