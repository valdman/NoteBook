package com.lod.boris.notebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> noteArrayList = new ArrayList<Note>();
    ListView noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_add_note_button();

        NoteAdapter adapter = new NoteAdapter(this, noteArrayList);
        noteList = (ListView)findViewById(R.id.List_view);
        noteList.setAdapter(adapter);
    }

    private void init_add_note_button() {
        Button addNoteButton = (Button)findViewById(R.id.CreateNoteButton);

        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteArrayList.add(new Note("Новая заметка", "Пустой текст заметки"));
                noteList.notifyDataSetChanged();
            }
        });
    }

}
