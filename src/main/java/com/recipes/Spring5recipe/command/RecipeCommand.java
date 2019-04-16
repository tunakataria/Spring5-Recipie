package com.recipes.Spring5recipe.command;

import com.recipes.Spring5recipe.model.Difficulty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class RecipeCommand {

    private Long id;
    private String description;
    private String name;
    private Integer cookingTime;
    private Integer preparationTime;
    private Integer rating;
    private String url;
    private Set<IngredientCommand> ingredients;
    private Set<CategoryCommand> categories;
    private NotesCommand notes;
    private Difficulty difficulty;
    private String source;
    private String directions;
    private String servings;

}

