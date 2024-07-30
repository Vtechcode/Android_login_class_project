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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare variables
private EditText textName;
private EditText textPassword;
private Button buttonSubmit;
private EditText textEmail;
private EditText confirmPass;
private TextView errorView;

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
        textEmail = findViewById(R.id.email);
        confirmPass = findViewById(R.id.confirm);
        errorView = findViewById(R.id.error);

        // Listen for when the submit button is clicked
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // convert inputs to strings
                    String name = textName.getText().toString();
                    String password = textPassword.getText().toString();
                    String email = textEmail.getText().toString();
                    String confirm = confirmPass.getText().toString();

                    //confirm if passwords are matching
                if(password.equals(confirm)) {
                    errorView.setText("");
                    Intent detailsActivity = new Intent(MainActivity.this, DetailActivity.class);
                    detailsActivity.putExtra("name", name);
                    detailsActivity.putExtra("password", password);
                    detailsActivity.putExtra("email", email);
                    startActivity(detailsActivity);
                }

                // throw an error if passwords are not matching
                else
                {
                    errorView.setText("Passwords not matching");

                }
            }
        });
        {

        }




    }



}