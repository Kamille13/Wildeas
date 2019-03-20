package com.example.wiideas;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

import static android.os.Build.VERSION_CODES.KITKAT;

public class AddActivity extends AppCompatActivity {

    User muUserAddActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //Crée la ToolBar avec le bouton retour
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMainActivity = new Intent(AddActivity.this, MainActivity.class);
                goMainActivity.putExtra("toMainActivity", (Parcelable) muUserAddActivity);
                startActivity(goMainActivity);
            }
        });

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

                Idea newIdea = new Idea(TitleText,DescriptionText);
                muUserAddActivity.getIdea().add(newIdea);

                Intent goMainActivity = new Intent(AddActivity.this, MainActivity.class);
                goMainActivity.putExtra("toMainActivity", (Parcelable) muUserAddActivity);
                startActivity(goMainActivity);
            }
        });
    }
}
