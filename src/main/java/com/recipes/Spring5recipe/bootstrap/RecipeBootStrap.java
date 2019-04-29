package com.recipes.Spring5recipe.bootstrap;

import com.recipes.Spring5recipe.model.*;
import com.recipes.Spring5recipe.repositories.CategoryRepository;
import com.recipes.Spring5recipe.repositories.RecipeRepository;
import com.recipes.Spring5recipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RecipeBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    UnitOfMeasureRepository unitOfMeasureRepository;
    RecipeRepository recipeRepository;
    CategoryRepository categoryRepository;

    public RecipeBootStrap(UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        recipeRepository.saveAll(getRecipes());

    }

    private Set<Recipe> getRecipes() {

        Optional<UnitOfMeasure> pinchOptional = unitOfMeasureRepository.findByUnit("Pinch");
        Optional<UnitOfMeasure> oZOptional = unitOfMeasureRepository.findByUnit("Oz");

        Set<Recipe> newRecipes = new HashSet<>();

        Recipe malaiTikka = new Recipe(30,40,"https://somwrecipe.com",Difficulty.MODERATE);
        malaiTikka.setName("Malai Tikka");

        malaiTikka.setDescription("Malai Tikka");
        malaiTikka.setDirections("Directions For MalaiTikka");
        malaiTikka.setCookingTime(20);
        malaiTikka.setPreparationTime(40);
        malaiTikka.setServings("4");
        malaiTikka.setSource("idianRecipes.com");
        malaiTikka.setUrl("https://indianrecipes.com");

        newRecipes.add(malaiTikka);
        Category indian = new Category("Indian Cuisine");
        Category mughlai = new Category("Punjabi Cuisine");
        Category vegetarian = new Category("Vegetarian");

        indian.setRecipes(newRecipes);
        mughlai.setRecipes(newRecipes);
        vegetarian.setRecipes(newRecipes);

        Set<Category> malaiTikkaCategories = new HashSet<>();
        malaiTikkaCategories.add(indian);
        malaiTikkaCategories.add(mughlai);
        malaiTikkaCategories.add(vegetarian);

        malaiTikka.setCategories(malaiTikkaCategories);

        Ingredient ilaichi = new Ingredient("ilaichi",pinchOptional.get());
        Ingredient milk = new Ingredient("milk",oZOptional.get());
        UnitOfMeasure uomIlaichi = new UnitOfMeasure();
        uomIlaichi.setUnit("pinch");
        ilaichi.setAmount("1");
        ilaichi.setRecipe(malaiTikka);
        ilaichi.setUom(uomIlaichi);
        milk.setRecipe(malaiTikka);
        UnitOfMeasure uomForMils = new UnitOfMeasure();
        uomForMils.setUnit("litre");
        milk.setAmount("1");
        milk.setUom(uomForMils);

        Set<Ingredient> ingredientsForMalaiTikka = new HashSet<>();
        ingredientsForMalaiTikka.add(ilaichi);
        ingredientsForMalaiTikka.add(milk);

        malaiTikka.setIngredients(ingredientsForMalaiTikka);

        Notes malaiTikkaNotes = new Notes();
        malaiTikkaNotes.setRecipeNotes("Notes for malaiTikka");
        malaiTikkaNotes.setRecipe(malaiTikka);

        malaiTikka.setNotes(malaiTikkaNotes);

        return newRecipes;

    }
}
