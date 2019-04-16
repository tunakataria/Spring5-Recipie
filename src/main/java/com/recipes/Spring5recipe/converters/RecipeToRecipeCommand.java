package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.command.RecipeCommand;
import com.recipes.Spring5recipe.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class RecipeToRecipeCommand {

   private IngredientToIngredientCommand ingredientToIngredientCommand;
   private CategoryToCategoryCommand categoryToCategoryCommand;
   private NotesToNotesCommand notesToNotesCommand;

    public RecipeToRecipeCommand(IngredientToIngredientCommand ingredientToIngredientCommand, CategoryToCategoryCommand categoryToCategoryCommand, NotesToNotesCommand notesToNotesCommand) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.notesToNotesCommand = notesToNotesCommand;
    }

    public RecipeCommand convert(Recipe recipe) {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setName(recipe.getName());
        recipeCommand.setCookingTime(recipe.getCookingTime());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setPreparationTime(recipe.getPreparationTime());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setNotes(notesToNotesCommand.convert(recipe.getNotes()));
        Set<IngredientCommand> ingredientCommandSet = new HashSet<>();
        /*for (Ingredient ingredient : recipe.getIngredients()) {
            ingredientCommandSet.add(ingredientToIngredientCommand.convert(ingredient));
        }
        Set<CategoryCommand> categoryCommands = new HashSet<>();
        recipe.getCategories().forEach(category -> categoryCommands.add(categoryToCategoryCommand.convert(category)));
*/
        return recipeCommand;
    }
}
