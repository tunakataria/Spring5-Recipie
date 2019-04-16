package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand {

private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    public IngredientCommand convert(Ingredient ingredient) {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setIngredientName(ingredient.getIngredientName());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureCommand.convert(ingredient.getUom()));
        return ingredientCommand;
    }
}
