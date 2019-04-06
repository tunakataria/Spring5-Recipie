package com.recipes.Spring5recipe.model;

public enum Difficulty {

    SIMPLE("SIMPLE"),
    MEDIUM("MEDIUM"),
    HARD("HARD");

    private String difficulty;
    Difficulty(String difficulty) {
        this.difficulty= difficulty;
    }
}
