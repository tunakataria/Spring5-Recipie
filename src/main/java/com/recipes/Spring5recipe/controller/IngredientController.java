package com.recipes.Spring5recipe.controller;

import com.recipes.Spring5recipe.Services.IngredientService;
import com.recipes.Spring5recipe.Services.RecipeService;
import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.command.RecipeCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngredientController {

    RecipeService recipeService;

    IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @RequestMapping({"/recipe/{id}/ingredients"})
    public String getIngredients(@PathVariable String id, Model model){
        RecipeCommand savedRecipeCommand = recipeService.findRecipeCommandById(Long.valueOf(id));
        model.addAttribute("recipe", savedRecipeCommand);
        return "recipe/ingredients";
    }

    @GetMapping
    @RequestMapping({"/recipe/{recipeId}/ingredient/{ingredientId}/update"})
    public String update(@PathVariable String recipeId, @PathVariable String ingredientId, Model model){
        RecipeCommand savedRecipeCommand = recipeService.findRecipeCommandById(Long.valueOf(recipeId));
        IngredientCommand ingredientCommand = savedRecipeCommand.getIngredients().stream().filter($->$.getId().equals(Long.valueOf(ingredientId))).findFirst().get();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);
        model.addAttribute("recipe", savedRecipeCommand);
        return "ingredient/form";
    }

    @PostMapping
    @RequestMapping("ingredientUpdate")
    public String ingredientUpdate(@ModelAttribute IngredientCommand ingredientCommand){
       IngredientCommand savedIngredientCommand = ingredientService.saveIngredientCommandForARecipe(ingredientCommand);
       return "redirect:/recipe/"+ingredientService.findById(savedIngredientCommand.getId()).getRecipe().getId()+"/ingredients";
    }

    @GetMapping
    @RequestMapping({"/recipe/{recipeId}/ingredient/{ingredientId}/show"})
    public String viewIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model){
        RecipeCommand savedRecipeCommand = recipeService.findRecipeCommandById(Long.valueOf(recipeId));
        IngredientCommand ingredientCommand = savedRecipeCommand.getIngredients().stream().filter($->$.getId().equals(Long.valueOf(ingredientId))).findFirst().get();
        model.addAttribute("ingredient", ingredientCommand);
        return "ingredient/ingredient";
    }

}
