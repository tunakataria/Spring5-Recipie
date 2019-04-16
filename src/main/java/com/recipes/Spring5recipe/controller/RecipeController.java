package com.recipes.Spring5recipe.controller;

import com.recipes.Spring5recipe.Services.RecipeService;
import com.recipes.Spring5recipe.command.NotesCommand;
import com.recipes.Spring5recipe.command.RecipeCommand;
import com.recipes.Spring5recipe.converters.RecipeCommandToRecipe;
import com.recipes.Spring5recipe.converters.RecipeToRecipeCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private RecipeService recipeService;
    private RecipeToRecipeCommand recipeToRecipeCommand;
    private RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeController(RecipeService recipeService, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeService = recipeService;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @RequestMapping({"", "/", "index.html"})
    public String getIndex(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }

    @RequestMapping({"/recipe/show/{id}"})
    public String showById(@PathVariable String id, Model model){
        RecipeCommand saveRecipeCommand = recipeService.findRecipeCommandById(new Long(id));
        model.addAttribute("recipe", saveRecipeCommand );
        return "recipe/show";
    }

    @RequestMapping({"/recipe/new"})
    public String addNew(Model model){
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setSource("https://someurl.com");
        recipeCommand.setUrl("https://indiarecipe.com");
        recipeCommand.setDescription("Please Write a new description here");
        recipeCommand.setServings("3");
        recipeCommand.setName("Some Tikka");
        recipeCommand.setDirections("This is the sample directions");
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setRecipeNotes("This is the sample notes");
        recipeCommand.setNotes(notesCommand);
        model.addAttribute("recipe", recipeCommand);

        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String create(@ModelAttribute RecipeCommand recipeCommand){
        RecipeCommand savedRecipe = recipeService.saveRecipeCommand(recipeCommand);
        return  "redirect:/recipe/show/"+savedRecipe.getId();

    }
}
