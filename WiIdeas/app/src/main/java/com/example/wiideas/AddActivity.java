package com.example.wiideas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    User muUserAddActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent receiveMainActivity = getIntent();
        muUserAddActivity = receiveMainActivity.getParcelableExtra("userGoAddActivity");


        final Button Add = findViewById(R.id.buttonAdd);
        Add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                EditText Title = findViewById(R.id.editTextTitle);
                EditText Description = findViewById(R.id.editTextDescription);
                String TitleText = Title.getText().toString();
                String DescriptionText = Description.getText().toString();

                System.out.println(TitleText);
                System.out.println(DescriptionText);

                Idea newIdea = new Idea(TitleText,DescriptionText);
                muUserAddActivity.getIdea().add(newIdea);

                Intent goMainActivity = new Intent(AddActivity.this, MainActivity.class);
                goMainActivity.putExtra("toMainActivity", (Parcelable) muUserAddActivity);
                startActivity(goMainActivity);
            }
        });
    }
}
