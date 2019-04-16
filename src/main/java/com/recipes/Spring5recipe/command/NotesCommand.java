package com.recipes.Spring5recipe.command;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NotesCommand {

    private Long id;
    private String recipeNotes;
}
