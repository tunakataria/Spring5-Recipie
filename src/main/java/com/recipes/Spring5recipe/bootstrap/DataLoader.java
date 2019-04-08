package com.recipes.Spring5recipe.bootstrap;

import com.recipes.Spring5recipe.repositories.CategoryRepository;
import com.recipes.Spring5recipe.repositories.IngredientRepository;
import com.recipes.Spring5recipe.repositories.RecipeRepository;
import com.recipes.Spring5recipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;


    public DataLoader(CategoryRepository categoryRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
