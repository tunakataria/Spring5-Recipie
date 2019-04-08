package com.recipes.Spring5recipe.controller;


import com.recipes.Spring5recipe.model.Ingredient;
import com.recipes.Spring5recipe.model.Recipe;
import com.recipes.Spring5recipe.repositories.CategoryRepository;
import com.recipes.Spring5recipe.repositories.RecipeRepository;
import com.recipes.Spring5recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public RecipeController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"","/","index.html"})
    public String getIndex(Model model){

        Recipe recipe = recipeRepository.findById(1L).get();

        for (Ingredient ingredient : recipe.getIngredients()) {

            System.out.println(ingredient.getIngredientName());

        }

        recipe.getCategories().forEach($-> System.out.println($.getDescription()));

        model.addAttribute("recipes", recipeRepository.findAll() );
        return "index";
    }
}
