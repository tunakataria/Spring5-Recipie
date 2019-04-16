package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient {

    private UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure) {
        this.unitOfMeasureCommandToUnitOfMeasure = unitOfMeasureCommandToUnitOfMeasure;
    }

    public Ingredient convert(IngredientCommand ingredientCommand) {

        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientCommand.getIngredientName());
        ingredient.setAmount(ingredientCommand.getAmount());
        ingredient.setUom(unitOfMeasureCommandToUnitOfMeasure.convert(ingredientCommand.getUnitOfMeasure()));
        return ingredient;
    }
}
