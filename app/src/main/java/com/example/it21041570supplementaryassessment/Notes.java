package com.example.it21041570supplementaryassessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.it21041570supplementaryassessment.Database.Constants;
import com.example.it21041570supplementaryassessment.Database.DatabaseHelper;
import com.example.it21041570supplementaryassessment.Fragments.ViewNotes;

public class Notes extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        getSupportFragmentManager().beginTransaction().add(R.id.container, new ViewNotes()).commit();
    }

}