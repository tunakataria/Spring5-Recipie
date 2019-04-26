package com.recipes.Spring5recipe.Services.springDataServices;

import com.recipes.Spring5recipe.converters.RecipeCommandToRecipe;
import com.recipes.Spring5recipe.converters.RecipeToRecipeCommand;
import com.recipes.Spring5recipe.model.Recipe;
import com.recipes.Spring5recipe.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class RecipeSpringDataServiceTest {

    RecipeSpringDataService recipeSpringDataService;

    RecipeToRecipeCommand recipeToRecipeCommand;

    RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        recipeSpringDataService = new RecipeSpringDataService(recipeRepository,recipeCommandToRecipe,recipeToRecipeCommand);
    }

    @Test
    public void findById() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        when(recipeRepository.findAll()).thenReturn(recipes);
        Assert.assertEquals(recipes.size(), ((Set<Recipe>) recipeSpringDataService.findAll()).size());
        verify(recipeRepository, times(1)).findAll();
    }
}