package com.lod.boris.notebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by boris on 30.10.15.
 */
public class EditNote extends Activity{

    EditText nameEditor;
    EditText textEditor;
    Button cancelButton;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.editor);

        nameEditor = (EditText)findViewById(R.id.EditNameField);
        textEditor = (EditText)findViewById(R.id.EditTextField);
        cancelButton = (Button)findViewById(R.id.CancelButton);
        saveButton = (Button)findViewById(R.id.SaveButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_the_note();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel_editing();
            }
        });
    }

    private void cancel_editing() {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    private void save_the_note() {
        Intent intent = new Intent();
        intent.putExtra("newName", nameEditor.getText().toString());
        intent.putExtra("newText", textEditor.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
