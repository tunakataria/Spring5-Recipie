package com.recipes.Spring5recipe.command;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientCommand {

    private Long id;
    private String ingredientName;
    private UnitOfMeasureCommand uom;
    private String amount;
    private Long recipeId;
}
