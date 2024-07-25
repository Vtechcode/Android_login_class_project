package com.example.class_project;

import android.os.Bundle;

import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Declare variables
private EditText textName;
private EditText textPassword;
private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        // initialize the variables
        textName = findViewById(R.id.textView);
        textPassword = findViewById(R.id.textView2);

        buttonSubmit = findViewById(R.id.btnSubmit);

        // Listen for when the submit button is clicked
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textName.getText().toString();
                String password = textPassword.getText().toString();
                Intent detailsActivity = new Intent(MainActivity.this, DetailActivity.class);
                detailsActivity.putExtra("name", name);
                detailsActivity.putExtra("password", password);
                startActivity(detailsActivity);
            }
        });
        {

        }




    }



}