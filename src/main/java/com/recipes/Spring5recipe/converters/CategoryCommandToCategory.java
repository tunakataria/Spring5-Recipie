package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.CategoryCommand;
import com.recipes.Spring5recipe.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory {

    public Category convert(CategoryCommand categoryCommand) {

        Category category = new Category();
        category.setDescription(categoryCommand.getDescription());
        return category;
    }
}
