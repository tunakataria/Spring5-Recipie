package com.recipes.Spring5recipe.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany()
    private Set<Recipe> recipes = new HashSet<>();

    public Category(String description) {
        this.description = description;
    }

}

