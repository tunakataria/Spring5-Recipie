package com.recipes.Spring5recipe.controller;

import com.recipes.Spring5recipe.Services.RecipeService;
import com.recipes.Spring5recipe.command.RecipeCommand;
import com.recipes.Spring5recipe.converters.RecipeCommandToRecipe;
import com.recipes.Spring5recipe.converters.RecipeToRecipeCommand;
import com.recipes.Spring5recipe.model.Difficulty;
import com.recipes.Spring5recipe.model.Ingredient;
import com.recipes.Spring5recipe.model.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest {

    RecipeController recipeController ;

    @Mock
    Model model;

    @Mock
    RecipeService recipeService;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    RecipeCommand recipeCommand;



    @Before
    public void setUp() throws Exception {
        initMocks(this);
        recipeController = new RecipeController(recipeService,recipeToRecipeCommand,recipeCommandToRecipe);
    }

    @Test
    public void getIndex() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());
        when(recipeService.findAll()).thenReturn(recipeSet);
        when(model.addAttribute("recipes", recipeService.findAll())).thenReturn(model);
        assertEquals("index",recipeController.getIndex(model));
    }

    @Test
    public void showById() {
        Recipe recipe = new Recipe();
        when(recipeService.findById(1L)).thenReturn(recipe);
        MockMvc mock = MockMvcBuilders.standaloneSetup(recipeController).build();
        try {
            mock.perform(get("/recipe/1/show")).andExpect(status().isOk()).andExpect(view().name("recipe/show"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void create() {
        recipeCommand.setId(1L);
        MockMvc mock = MockMvcBuilders.standaloneSetup(recipeController).build();
        when(recipeService.saveRecipeCommand(any())).thenReturn(recipeCommand);

        try {
            mock.perform(post("/recipe").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("cookingTime","30").param("name","yayayya").param("preparationTime","34").param("description","").param("notes.recipeNotes","lalala").param("difficulty", Difficulty.MODERATE.name())).andExpect(status().is3xxRedirection());
        }catch (Exception exception){

        }

    }
}