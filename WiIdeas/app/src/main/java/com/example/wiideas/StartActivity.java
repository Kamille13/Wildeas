package com.example.wiideas;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;



public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Button button = findViewById(R.id.buttonGo);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                //Collect User identifiant
                EditText firstName = findViewById(R.id.editTextFirstName);
                String firstNameText = firstName.getText().toString();

                EditText lastName = findViewById(R.id.editTextLastName);
                String lastNameText = lastName.getText().toString();

                //Initialization of idea and user
                Idea ideaStartActivity = new Idea("Tittle","Description");
                User userStarActivity = new User(firstNameText,lastNameText, ideaStartActivity);


                Intent StartActivity = new Intent(StartActivity.this, MainActivity.class);
                StartActivity.putExtra("user", (Parcelable) userStarActivity);
                startActivity(StartActivity);

            }
        });

    }
}
