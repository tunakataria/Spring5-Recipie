package com.recipes.Spring5recipe.Services.springDataServices;

import com.recipes.Spring5recipe.Services.RecipeService;
import com.recipes.Spring5recipe.command.RecipeCommand;
import com.recipes.Spring5recipe.converters.RecipeCommandToRecipe;
import com.recipes.Spring5recipe.converters.RecipeToRecipeCommand;
import com.recipes.Spring5recipe.model.Recipe;
import com.recipes.Spring5recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeSpringDataService implements RecipeService {

    RecipeRepository recipeRepository;
    RecipeCommandToRecipe recipeCommandToRecipe;
    RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeSpringDataService(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
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
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand){
      Recipe Recipe =   recipeCommandToRecipe.convert(recipeCommand);
      Recipe savedRecipe = save(Recipe);
      return recipeToRecipeCommand.convert(savedRecipe);

    }

    @Override
    public RecipeCommand findRecipeCommandById(Long id) {

        return recipeToRecipeCommand.convert(findById(id));
    }
}
