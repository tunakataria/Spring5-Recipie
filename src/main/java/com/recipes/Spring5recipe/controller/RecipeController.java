package com.recipes.Spring5recipe.controller;

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

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "index.html"})
    public String getIndex(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "index";
    }
}
