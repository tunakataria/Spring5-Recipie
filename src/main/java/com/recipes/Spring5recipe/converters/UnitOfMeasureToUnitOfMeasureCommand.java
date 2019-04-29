package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.UnitOfMeasureCommand;
import com.recipes.Spring5recipe.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    public UnitOfMeasureCommand convert(UnitOfMeasure uom) {
        if (uom == null) {
            return null;
        }

        final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setUnit(uom.getUnit());
        unitOfMeasureCommand.setId(uom.getId());
        return unitOfMeasureCommand;
    }
}
