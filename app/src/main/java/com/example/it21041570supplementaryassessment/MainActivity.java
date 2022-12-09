
package com.example.it21041570supplementaryassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.password);
        button = findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText1.getText().toString().equals("admin") && editText2.getText().toString().equals("admin")){
                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Check user name and password again!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}