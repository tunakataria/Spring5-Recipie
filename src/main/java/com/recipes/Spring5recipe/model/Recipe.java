package com.recipes.Spring5recipe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer cookingTime;
    private Integer preparationTime;
    private Integer rating;
    private String url;
    private String servings;
    private String description;



    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    private String source;

    @Lob
    private String directions;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @Lob
    Byte[] image;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "recipes", fetch = FetchType.EAGER)
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    public Recipe(Integer cookingTime, Integer preparationTime, String url, Difficulty difficulty) {
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
        this.url = url;
        this.difficulty = difficulty;
    }
}
