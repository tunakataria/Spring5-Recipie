package com.recipes.Spring5recipe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingredientName;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
     private UnitOfMeasure uom;

    public Ingredient(String ingredientName, UnitOfMeasure uom) {
        this.ingredientName = ingredientName;
        this.uom = uom;
    }


}
