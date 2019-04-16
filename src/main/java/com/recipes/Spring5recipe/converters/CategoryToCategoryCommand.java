package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.CategoryCommand;
import com.recipes.Spring5recipe.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand {

    public CategoryCommand convert(Category category) {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setDescription(category.getDescription());
        return categoryCommand;
    }
}
