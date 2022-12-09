package com.example.it21041570supplementaryassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.it21041570supplementaryassessment.Database.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditNotes extends AppCompatActivity {

    EditText editText;
    Button button1;
    Button button2;
    private DatabaseHelper dbHelper;
    String id, note;
    private boolean editMode = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);

        editText = findViewById(R.id.updatenote);
        button1 = findViewById(R.id.update);
        button2 = findViewById(R.id.cancel);
        dbHelper = new DatabaseHelper(EditNotes.this);

        Intent intent = getIntent();
        editMode = intent.getBooleanExtra("EditMode", editMode);
        id = intent.getStringExtra("ID");
        note = intent.getStringExtra("note");

        if(editMode){
            editText.setText(note);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = editText.getText().toString();

                if(note.isEmpty()){
                    editText.setError("Note cannot be empty!");
                }else{

                    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                    String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

                    dbHelper.updateInfo(
                            "" + id,
                            "" + note,
                            "" + currentDate,
                            "" + currentTime);

                    Toast.makeText(EditNotes.this, "Details updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditNotes.this, Notes.class);
                startActivity(intent);
            }
        });
    }
}