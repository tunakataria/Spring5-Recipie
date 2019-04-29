package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.RecipeCommand;
import com.recipes.Spring5recipe.model.Ingredient;
import com.recipes.Spring5recipe.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private IngredientCommandToIngredient ingredientCommandToIngredient;
    private CategoryCommandToCategory categoryCommandToCategory;
    private NotesCommandToNotes notesCommandToNotes;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient, CategoryCommandToCategory categoryCommandToCategory, NotesCommandToNotes notesCommandToNotes) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    @Override
    @Synchronized
    @Nullable
    public Recipe convert(RecipeCommand recipeCommand) {
        if (recipeCommand == null) {
            return null;
        }
        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
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
        /*Set<Ingredient> ingredientSet = new HashSet<>();
        *//*recipeCommand.getIngredients().forEach(ingredientCommand -> ingredientSet.add(ingredientCommandToIngredient.convert(ingredientCommand)));*//*
        recipe.setIngredients(ingredientSet);*/
        return recipe;
    }
}
