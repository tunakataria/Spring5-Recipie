package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.UnitOfMeasureCommand;
import com.recipes.Spring5recipe.model.UnitOfMeasure;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand {

    public UnitOfMeasureCommand convert(UnitOfMeasure uom) {
       UnitOfMeasureCommand unitOfMeasureCommand =  new UnitOfMeasureCommand();
       unitOfMeasureCommand.setUnit(uom.getUnit());
       return unitOfMeasureCommand;
    }
}
