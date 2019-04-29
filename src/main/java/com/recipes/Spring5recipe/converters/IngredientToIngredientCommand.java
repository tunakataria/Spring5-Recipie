package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.model.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    @Synchronized
    @Nullable
    public IngredientCommand convert(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setIngredientName(ingredient.getIngredientName());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setUom(unitOfMeasureToUnitOfMeasureCommand.convert(ingredient.getUom()));
        return ingredientCommand;
    }
}
