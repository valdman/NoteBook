package com.lod.boris.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Note> noteArrayList = new ArrayList<Note>();
    ListView noteList;
    NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_add_note_button();
        init_del_all_notes_button();

        adapter = new NoteAdapter(this, noteArrayList);
        noteList = (ListView)findViewById(R.id.List_view);
        noteList.setAdapter(adapter);
    }

    private void init_del_all_notes_button() {
        Button dellAllButton = (Button)findViewById(R.id.DeleteAllButton);
        dellAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteArrayList.clear();
                adapter.notifyDataSetChanged();

            }
        });
    }

    private void init_add_note_button() {
        Button addNoteButton = (Button)findViewById(R.id.CreateNoteButton);

        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteArrayList.add(new Note("Новая заметка", "Электронный паспорт содержит в себе данные, которые разнесены по четырем основным функциональным блокам. Первый из них — это персональные данные. Этот функциональный блок включает в себя имя, фамилию, отчество, год рождения, семейное положение, прописку, сведения о детях и прочую информацию о гражданине.\n" +
                        "\n" +
                        "Вторым функциональным блоком является информация о визах. Эта информация выносится в отдельную группу, поскольку она обновляется и дополняется гораздо чаще.\n" +
                        "\n" +
                        "Третьим блоком являются биометрические данные. К ним относятся: фотография гражданина в формате jpg, отпечатки пальцев, снимок сетчатки глаза и любые другие данные, которые физиологически подтверждают личность человека."));
                adapter.notifyDataSetChanged();;
            }
        });
    }

}
