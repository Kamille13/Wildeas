package com.example.wiideas;

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


                Intent StartActivity = new Intent(StartActivity.this, MainActivity.class);
                StartActivity.putExtra("firstName",firstNameText);
                StartActivity.putExtra("name",lastNameText);
                startActivity(StartActivity);

            }
        });

    }
}
