package com.example.class_project;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.example.class_project.DetailActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView textDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textDetail = findViewById(R.id.Display);

        // Get Data passed from MainActivity
        Bundle passed = getIntent().getExtras();
        if(passed != null)
        {
            String name = passed.getString("name");
            String password = passed.getString("password");
            String email = passed.getString("email");
            textDetail.setText("Name: " + name + "\nPassword: " + password + "\nEmail: " + email);
        }
    }
}
