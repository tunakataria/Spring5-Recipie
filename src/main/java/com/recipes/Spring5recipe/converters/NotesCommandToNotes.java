package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.NotesCommand;
import com.recipes.Spring5recipe.model.Notes;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes {


    public Notes convert(NotesCommand notesCommand) {

        Notes notes = new Notes();
        notes.setRecipeNotes(notesCommand.getRecipeNotes());
        return notes;
    }
}
