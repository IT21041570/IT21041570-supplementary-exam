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

public class AddNotes extends AppCompatActivity {

    EditText editText;
    Button button1;
    Button button2;
    private DatabaseHelper dbHelper;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        editText = findViewById(R.id.note);
        button1 = findViewById(R.id.save);
        button2 = findViewById(R.id.cancel);
        dbHelper = new DatabaseHelper(AddNotes.this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = editText.getText().toString();

                if(note.isEmpty()){
                    editText.setError("Note cannot be empty!");
                }else{

                    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                    String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

                    dbHelper.insertInfo(
                            "" + note,
                            "" + currentDate,
                            "" + currentTime);

                    Toast.makeText(AddNotes.this, "Entered details successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddNotes.this, "Cancelled", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddNotes.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}