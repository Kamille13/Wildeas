package com.example.wiideas;

import android.graphics.Color;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class StartActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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


                Intent fromStartActivity = new Intent(StartActivity.this, MainActivity.class);
                fromStartActivity.putExtra("toMainActivity", (Parcelable) userStarActivity);
                startActivity(fromStartActivity);




            }
        });

    }
}
