package com.recipes.Spring5recipe.Services.springDataServices;

import com.recipes.Spring5recipe.Services.IngredientService;
import com.recipes.Spring5recipe.command.IngredientCommand;
import com.recipes.Spring5recipe.converters.IngredientCommandToIngredient;
import com.recipes.Spring5recipe.converters.IngredientToIngredientCommand;
import com.recipes.Spring5recipe.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.recipes.Spring5recipe.model.Ingredient;
import com.recipes.Spring5recipe.model.Recipe;
import com.recipes.Spring5recipe.repositories.IngredientRepository;
import com.recipes.Spring5recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class IngredientDataService implements IngredientService {

    IngredientRepository ingredientRepository ;

    IngredientCommandToIngredient ingredientCommandToIngredient;

    IngredientToIngredientCommand ingredientToIngredientCommand;

    RecipeRepository recipeRepository ;

    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    public IngredientDataService(IngredientRepository ingredientRepository, IngredientCommandToIngredient ingredientCommandToIngredient, IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository, UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureCommandToUnitOfMeasure = unitOfMeasureCommandToUnitOfMeasure;
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).get();
    }

    @Override
    public Ingredient save(Ingredient object) {
        return ingredientRepository.save(object);
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Iterable<Ingredient> findByName(String ingredientName) {

        Set<Ingredient> ingredients = new HashSet<>();

        for (Ingredient ingredient : ingredientRepository.findAll()) {
          if(ingredient.getIngredientName().equals(ingredientName)){
              ingredients.add(ingredient);
          }
        }
        return ingredients;
    }

    @Override
    public IngredientCommand findIngredientCommandById(Long id) {
        Ingredient savedIngredient = findById(id);
        return ingredientToIngredientCommand.convert(savedIngredient);
    }

    @Override
    public IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand) {
        Ingredient savedIngredient =  save(ingredientCommandToIngredient.convert(ingredientCommand));
        return ingredientToIngredientCommand.convert(savedIngredient);
    }

    @Override
    public IngredientCommand saveIngredientCommandForARecipe(IngredientCommand ingredientCommand) {

        Recipe savedRecipe  = recipeRepository.findById(ingredientCommand.getRecipeId()).get();
        Optional<Ingredient> ingredientOptionaal= savedRecipe.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientCommand.getId())).findFirst();
        Ingredient matchedIngredient = ingredientOptionaal.get();

        matchedIngredient.setUom(unitOfMeasureCommandToUnitOfMeasure.convert(ingredientCommand.getUom()));
        matchedIngredient.setIngredientName(ingredientCommand.getIngredientName());
        matchedIngredient.setAmount(ingredientCommand.getAmount());
        matchedIngredient.setId(ingredientCommand.getId());


        savedRecipe = recipeRepository.save(savedRecipe);
        return ingredientToIngredientCommand.convert(savedRecipe.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientCommand.getId())).findFirst().get());

    }


}
