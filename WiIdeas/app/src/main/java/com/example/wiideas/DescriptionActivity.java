package com.example.wiideas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        //receive ideas
        Intent receiveMainActivity = getIntent();
        final User userDescriptiontActivity = receiveMainActivity.getParcelableExtra("userGoDescriptionActivity");
        final String indexDescriptionActivity = receiveMainActivity.getStringExtra("indexGoDescriptionActivity");
        final int index =Integer.parseInt(indexDescriptionActivity);


        //display ideas
        TextView tittle = (TextView) findViewById(R.id.textView);
        TextView description = (TextView) findViewById(R.id.textView2);
        description.setText(userDescriptiontActivity.getIdea().get(index).getIdeaTittle());
        tittle.setText(userDescriptiontActivity.getIdea().get(index).getIdeaContent());


        //remove ideas

        final Button button = findViewById(R.id.buttonRemove);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

               userDescriptiontActivity.getIdea().remove(index);

               Intent goMainActivity = new Intent(DescriptionActivity.this, MainActivity.class);
               goMainActivity.putExtra("toMainActivity", (Parcelable) userDescriptiontActivity);
               startActivity(goMainActivity);

            }
        });

        //Crée la ToolBar avec le bouton retour
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMainActivity = new Intent(DescriptionActivity.this, MainActivity.class);
                goMainActivity.putExtra("toMainActivity", (Parcelable) userDescriptiontActivity);
                startActivity(goMainActivity);
            }
        });


    }



}

