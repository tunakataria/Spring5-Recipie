package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.RecipeCommand;
import com.recipes.Spring5recipe.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe {

    private IngredientCommandToIngredient ingredientCommandToIngredient;
    private CategoryCommandToCategory categoryCommandToCategory;
    private NotesCommandToNotes notesCommandToNotes;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient, CategoryCommandToCategory categoryCommandToCategory, NotesCommandToNotes notesCommandToNotes) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    public Recipe convert(RecipeCommand recipeCommand) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeCommand.getName());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setCookingTime(recipeCommand.getCookingTime());
        recipe.setPreparationTime(recipeCommand.getPreparationTime());
        recipe.setServings(recipeCommand.getServings());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setSource(recipeCommand.getSource());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotes()));
        return recipe;
    }
}
