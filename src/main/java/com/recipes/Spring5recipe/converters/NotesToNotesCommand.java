package com.recipes.Spring5recipe.converters;

import com.recipes.Spring5recipe.command.NotesCommand;
import com.recipes.Spring5recipe.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Override
    @Nullable
    @Synchronized
    public NotesCommand convert(Notes notes) {
        if (notes == null) {
            return null;
        }
        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setRecipeNotes(notes.getRecipeNotes());
        notesCommand.setId(notes.getId());
        return notesCommand;
    }
}
