package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.UnitOfMeasureCommand;
import com.recipes.Spring5recipe.model.UnitOfMeasure;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure {

    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setUnit(unitOfMeasureCommand.getUnit());
        return unitOfMeasure;
    }
}
