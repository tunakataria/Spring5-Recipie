package com.recipes.Spring5recipe.controller;

import com.recipes.Spring5recipe.Services.RecipeService;
import com.recipes.Spring5recipe.model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeRepository) {
        this.recipeService = recipeRepository;
    }

    @RequestMapping({"", "/", "index.html"})
    public String getIndex(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }

    @RequestMapping({"recipe/show/{id}"})
    public String showById(@PathVariable String id, Model model){
        Recipe recipe = recipeService.findById(new Long(id));
        model.addAttribute("recipe", recipe );
        model.addAttribute("ingredients", recipe.getIngredients());
        recipe.getIngredients().forEach(System.out::print);
        return "recipe/show";
    }
}
