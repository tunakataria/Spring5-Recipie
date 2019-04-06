package com.recipes.Spring5recipe.model;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Recipe recipe;

    @OneToOne
    UoM uom;

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

    public UoM getUom() {
        return uom;
    }

    public void setUom(UoM uom) {
        this.uom = uom;
    }
}
