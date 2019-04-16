package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.NotesCommand;
import com.recipes.Spring5recipe.model.Notes;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand {

    public NotesCommand convert(Notes notes) {
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setRecipeNotes(notes.getRecipeNotes());
        notesCommand.setId(notes.getId());
        return notesCommand;
    }
}
