package com.recipes.Spring5recipe.model;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String ingredientName;

    @ManyToOne
    Recipe recipe;

    @OneToOne
    UnitOfMeasure uom;

    public Ingredient() {
    }

    public Ingredient(String ingredientName, UnitOfMeasure uom) {
        this.ingredientName = ingredientName;
        this.recipe = recipe;
        this.uom = uom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }


    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
