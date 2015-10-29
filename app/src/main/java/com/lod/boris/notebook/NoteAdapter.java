package com.lod.boris.notebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by boris on 29.10.15.
 */
public class NoteAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Note> notes;

    public NoteAdapter(Context _context, ArrayList<Note> _notes) {
        ctx = _context;
        notes = _notes;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final Note n = getNote(position);

        view = lInflater.inflate(R.layout.note_template, parent, false);

        TextView nameOfNote = (TextView) view.findViewById(R.id.NameOfNoteTextView);
        TextView shortDescOfNote = (TextView)view.findViewById(R.id.ShortDescriptionTextView);
        Button delButton = (Button) view.findViewById(R.id.DeleteNoteButton);

        nameOfNote.setText(n.getName());
        shortDescOfNote.setText(n.getShort_text());

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete_note();
            }
        });

        nameOfNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_note(n);
            }
        });

        shortDescOfNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_note(n);
            }
        });

        return view;
    }

    Note getNote(int position) {

        return ((Note) getItem(position));
    }

    private void delete_note() {
        // Здесь долны быть действия по нажатию кнопки удаления заметки
    }


    private void edit_note(Note noteToEdit){
        // Тут запуск вьюхи-редактора заметки noteToEdit

    }
}
