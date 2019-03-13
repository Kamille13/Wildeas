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
                EditText firstName = findViewById(R.id.editTextFirstName);
                String firstNameText = firstName.getText().toString();

                EditText lastName = findViewById(R.id.editTextLastName);
                String lastNameText = lastName.getText().toString();

                Intent testActivity = new Intent(StartActivity.this, MainActivity.class);
                testActivity.putExtra("firstName",firstNameText);
                testActivity.putExtra("lastName",lastNameText);
                startActivity(testActivity);

            }
        });
    }
}
